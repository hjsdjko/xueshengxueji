
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 教务人员姓名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jiaowurenyuan")
public class JiaowurenyuanController {
    private static final Logger logger = LoggerFactory.getLogger(JiaowurenyuanController.class);

    @Autowired
    private JiaowurenyuanService jiaowurenyuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("学生".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("教务人员姓名".equals(role))
            params.put("jiaowurenyuanId",request.getSession().getAttribute("userId"));
        params.put("jiaowurenyuanDeleteStart",1);params.put("jiaowurenyuanDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = jiaowurenyuanService.queryPage(params);

        //字典表数据转换
        List<JiaowurenyuanView> list =(List<JiaowurenyuanView>)page.getList();
        for(JiaowurenyuanView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JiaowurenyuanEntity jiaowurenyuan = jiaowurenyuanService.selectById(id);
        if(jiaowurenyuan !=null){
            //entity转view
            JiaowurenyuanView view = new JiaowurenyuanView();
            BeanUtils.copyProperties( jiaowurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaowurenyuanEntity jiaowurenyuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jiaowurenyuan:{}",this.getClass().getName(),jiaowurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JiaowurenyuanEntity> queryWrapper = new EntityWrapper<JiaowurenyuanEntity>()
            .eq("username", jiaowurenyuan.getUsername())
            .or()
            .eq("jiaowurenyuan_id_number", jiaowurenyuan.getJiaowurenyuanIdNumber())
            .andNew()
            .eq("jiaowurenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaowurenyuanEntity jiaowurenyuanEntity = jiaowurenyuanService.selectOne(queryWrapper);
        if(jiaowurenyuanEntity==null){
            jiaowurenyuan.setJiaowurenyuanDelete(1);
            jiaowurenyuan.setCreateTime(new Date());
            jiaowurenyuan.setPassword("123456");
            jiaowurenyuanService.insert(jiaowurenyuan);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaowurenyuanEntity jiaowurenyuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,jiaowurenyuan:{}",this.getClass().getName(),jiaowurenyuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<JiaowurenyuanEntity> queryWrapper = new EntityWrapper<JiaowurenyuanEntity>()
            .notIn("id",jiaowurenyuan.getId())
            .andNew()
            .eq("username", jiaowurenyuan.getUsername())
            .or()
            .eq("jiaowurenyuan_id_number", jiaowurenyuan.getJiaowurenyuanIdNumber())
            .andNew()
            .eq("jiaowurenyuan_delete", 1)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaowurenyuanEntity jiaowurenyuanEntity = jiaowurenyuanService.selectOne(queryWrapper);
        if(jiaowurenyuanEntity==null){
            jiaowurenyuanService.updateById(jiaowurenyuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<JiaowurenyuanEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JiaowurenyuanEntity jiaowurenyuanEntity = new JiaowurenyuanEntity();
            jiaowurenyuanEntity.setId(id);
            jiaowurenyuanEntity.setJiaowurenyuanDelete(2);
            list.add(jiaowurenyuanEntity);
        }
        if(list != null && list.size() >0){
            jiaowurenyuanService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JiaowurenyuanEntity> jiaowurenyuanList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JiaowurenyuanEntity jiaowurenyuanEntity = new JiaowurenyuanEntity();
//                            jiaowurenyuanEntity.setJiaowurenyuanUuidNumber(data.get(0));                    //工号 要改的
//                            jiaowurenyuanEntity.setUsername(data.get(0));                    //账户 要改的
//                            //jiaowurenyuanEntity.setPassword("123456");//密码
//                            jiaowurenyuanEntity.setJiaowurenyuanName(data.get(0));                    //教务人员姓名 要改的
//                            jiaowurenyuanEntity.setJiaowurenyuanIdNumber(data.get(0));                    //身份证号 要改的
//                            jiaowurenyuanEntity.setSexTypes(Integer.valueOf(data.get(0)));   //性别 要改的
//                            jiaowurenyuanEntity.setJiaowurenyuanDelete(1);//逻辑删除字段
//                            jiaowurenyuanEntity.setCreateTime(date);//时间
                            jiaowurenyuanList.add(jiaowurenyuanEntity);


                            //把要查询是否重复的字段放入map中
                                //工号
                                if(seachFields.containsKey("jiaowurenyuanUuidNumber")){
                                    List<String> jiaowurenyuanUuidNumber = seachFields.get("jiaowurenyuanUuidNumber");
                                    jiaowurenyuanUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaowurenyuanUuidNumber = new ArrayList<>();
                                    jiaowurenyuanUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaowurenyuanUuidNumber",jiaowurenyuanUuidNumber);
                                }
                                //账户
                                if(seachFields.containsKey("username")){
                                    List<String> username = seachFields.get("username");
                                    username.add(data.get(0));//要改的
                                }else{
                                    List<String> username = new ArrayList<>();
                                    username.add(data.get(0));//要改的
                                    seachFields.put("username",username);
                                }
                                //身份证号
                                if(seachFields.containsKey("jiaowurenyuanIdNumber")){
                                    List<String> jiaowurenyuanIdNumber = seachFields.get("jiaowurenyuanIdNumber");
                                    jiaowurenyuanIdNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jiaowurenyuanIdNumber = new ArrayList<>();
                                    jiaowurenyuanIdNumber.add(data.get(0));//要改的
                                    seachFields.put("jiaowurenyuanIdNumber",jiaowurenyuanIdNumber);
                                }
                        }

                        //查询是否重复
                         //工号
                        List<JiaowurenyuanEntity> jiaowurenyuanEntities_jiaowurenyuanUuidNumber = jiaowurenyuanService.selectList(new EntityWrapper<JiaowurenyuanEntity>().in("jiaowurenyuan_uuid_number", seachFields.get("jiaowurenyuanUuidNumber")).eq("jiaowurenyuan_delete", 1));
                        if(jiaowurenyuanEntities_jiaowurenyuanUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaowurenyuanEntity s:jiaowurenyuanEntities_jiaowurenyuanUuidNumber){
                                repeatFields.add(s.getJiaowurenyuanUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [工号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //账户
                        List<JiaowurenyuanEntity> jiaowurenyuanEntities_username = jiaowurenyuanService.selectList(new EntityWrapper<JiaowurenyuanEntity>().in("username", seachFields.get("username")).eq("jiaowurenyuan_delete", 1));
                        if(jiaowurenyuanEntities_username.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaowurenyuanEntity s:jiaowurenyuanEntities_username){
                                repeatFields.add(s.getUsername());
                            }
                            return R.error(511,"数据库的该表中的 [账户] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                         //身份证号
                        List<JiaowurenyuanEntity> jiaowurenyuanEntities_jiaowurenyuanIdNumber = jiaowurenyuanService.selectList(new EntityWrapper<JiaowurenyuanEntity>().in("jiaowurenyuan_id_number", seachFields.get("jiaowurenyuanIdNumber")).eq("jiaowurenyuan_delete", 1));
                        if(jiaowurenyuanEntities_jiaowurenyuanIdNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JiaowurenyuanEntity s:jiaowurenyuanEntities_jiaowurenyuanIdNumber){
                                repeatFields.add(s.getJiaowurenyuanIdNumber());
                            }
                            return R.error(511,"数据库的该表中的 [身份证号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jiaowurenyuanService.insertBatch(jiaowurenyuanList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }


    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        JiaowurenyuanEntity jiaowurenyuan = jiaowurenyuanService.selectOne(new EntityWrapper<JiaowurenyuanEntity>().eq("username", username));
        if(jiaowurenyuan==null || !jiaowurenyuan.getPassword().equals(password))
            return R.error("账号或密码不正确");
        else if(jiaowurenyuan.getJiaowurenyuanDelete() != 1)
            return R.error("账户已被删除");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(.getRoleTypes());
        String token = tokenService.generateToken(jiaowurenyuan.getId(),username, "jiaowurenyuan", "教务人员姓名");
        R r = R.ok();
        r.put("token", token);
        r.put("role","教务人员姓名");
        r.put("username",jiaowurenyuan.getJiaowurenyuanName());
        r.put("tableName","jiaowurenyuan");
        r.put("userId",jiaowurenyuan.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody JiaowurenyuanEntity jiaowurenyuan){
//    	ValidatorUtils.validateEntity(user);
        Wrapper<JiaowurenyuanEntity> queryWrapper = new EntityWrapper<JiaowurenyuanEntity>()
            .eq("username", jiaowurenyuan.getUsername())
            .or()
            .eq("jiaowurenyuan_id_number", jiaowurenyuan.getJiaowurenyuanIdNumber())
            .andNew()
            .eq("jiaowurenyuan_delete", 1)
            ;
        JiaowurenyuanEntity jiaowurenyuanEntity = jiaowurenyuanService.selectOne(queryWrapper);
        if(jiaowurenyuanEntity != null)
            return R.error("账户或者身份证号已经被使用");
        jiaowurenyuan.setJiaowurenyuanDelete(1);
        jiaowurenyuan.setCreateTime(new Date());
        jiaowurenyuanService.insert(jiaowurenyuan);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        JiaowurenyuanEntity jiaowurenyuan = new JiaowurenyuanEntity();
        jiaowurenyuan.setPassword("123456");
        jiaowurenyuan.setId(id);
        jiaowurenyuanService.updateById(jiaowurenyuan);
        return R.ok();
    }


    /**
     * 忘记密码
     */
    @IgnoreAuth
    @RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request) {
        JiaowurenyuanEntity jiaowurenyuan = jiaowurenyuanService.selectOne(new EntityWrapper<JiaowurenyuanEntity>().eq("username", username));
        if(jiaowurenyuan!=null){
            jiaowurenyuan.setPassword("123456");
            boolean b = jiaowurenyuanService.updateById(jiaowurenyuan);
            if(!b){
               return R.error();
            }
        }else{
           return R.error("账号不存在");
        }
        return R.ok();
    }


    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrJiaowurenyuan(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        JiaowurenyuanEntity jiaowurenyuan = jiaowurenyuanService.selectById(id);
        if(jiaowurenyuan !=null){
            //entity转view
            JiaowurenyuanView view = new JiaowurenyuanView();
            BeanUtils.copyProperties( jiaowurenyuan , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }





}
