
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
 * 学籍异动
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xuejiyidong")
public class XuejiyidongController {
    private static final Logger logger = LoggerFactory.getLogger(XuejiyidongController.class);

    @Autowired
    private XuejiyidongService xuejiyidongService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;

    @Autowired
    private JiaowurenyuanService jiaowurenyuanService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = xuejiyidongService.queryPage(params);

        //字典表数据转换
        List<XuejiyidongView> list =(List<XuejiyidongView>)page.getList();
        for(XuejiyidongView c:list){
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
        XuejiyidongEntity xuejiyidong = xuejiyidongService.selectById(id);
        if(xuejiyidong !=null){
            //entity转view
            XuejiyidongView view = new XuejiyidongView();
            BeanUtils.copyProperties( xuejiyidong , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(xuejiyidong.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R save(@RequestBody XuejiyidongEntity xuejiyidong, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xuejiyidong:{}",this.getClass().getName(),xuejiyidong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("学生".equals(role))
            xuejiyidong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<XuejiyidongEntity> queryWrapper = new EntityWrapper<XuejiyidongEntity>()
            .eq("xuejiyidong_text", xuejiyidong.getXuejiyidongText())
            .eq("xuejiyidong_types", xuejiyidong.getXuejiyidongTypes())
            .eq("yonghu_id", xuejiyidong.getYonghuId())
            .eq("xuejiyidong_yesno_types", xuejiyidong.getXuejiyidongYesnoTypes())
            .eq("xuejiyidong_yesno_text", xuejiyidong.getXuejiyidongYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuejiyidongEntity xuejiyidongEntity = xuejiyidongService.selectOne(queryWrapper);
        if(xuejiyidongEntity==null){
            xuejiyidong.setXuejiyidongYesnoTypes(1);
            xuejiyidong.setCreateTime(new Date());
            xuejiyidongService.insert(xuejiyidong);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XuejiyidongEntity xuejiyidong, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xuejiyidong:{}",this.getClass().getName(),xuejiyidong.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("学生".equals(role))
//            xuejiyidong.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<XuejiyidongEntity> queryWrapper = new EntityWrapper<XuejiyidongEntity>()
            .notIn("id",xuejiyidong.getId())
            .andNew()
            .eq("xuejiyidong_text", xuejiyidong.getXuejiyidongText())
            .eq("xuejiyidong_types", xuejiyidong.getXuejiyidongTypes())
            .eq("yonghu_id", xuejiyidong.getYonghuId())
            .eq("xuejiyidong_yesno_types", xuejiyidong.getXuejiyidongYesnoTypes())
            .eq("xuejiyidong_yesno_text", xuejiyidong.getXuejiyidongYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        XuejiyidongEntity xuejiyidongEntity = xuejiyidongService.selectOne(queryWrapper);
        if("".equals(xuejiyidong.getXuejiyidongFile()) || "null".equals(xuejiyidong.getXuejiyidongFile())){
                xuejiyidong.setXuejiyidongFile(null);
        }
        if(xuejiyidongEntity==null){
            xuejiyidongService.updateById(xuejiyidong);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody XuejiyidongEntity xuejiyidongEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,xuejiyidongEntity:{}",this.getClass().getName(),xuejiyidongEntity.toString());

//        if(xuejiyidongEntity.getXuejiyidongYesnoTypes() == 2){//通过
//            xuejiyidongEntity.setXuejiyidongTypes();
//        }else if(xuejiyidongEntity.getXuejiyidongYesnoTypes() == 3){//拒绝
//            xuejiyidongEntity.setXuejiyidongTypes();
//        }
        xuejiyidongService.updateById(xuejiyidongEntity);//审核
        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xuejiyidongService.deleteBatchIds(Arrays.asList(ids));
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
            List<XuejiyidongEntity> xuejiyidongList = new ArrayList<>();//上传的东西
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
                            XuejiyidongEntity xuejiyidongEntity = new XuejiyidongEntity();
//                            xuejiyidongEntity.setXuejiyidongText(data.get(0));                    //申请原因 要改的
//                            xuejiyidongEntity.setXuejiyidongFile(data.get(0));                    //申请文件 要改的
//                            xuejiyidongEntity.setXuejiyidongTypes(Integer.valueOf(data.get(0)));   //申请项目 要改的
//                            xuejiyidongEntity.setYonghuId(Integer.valueOf(data.get(0)));   //学生 要改的
//                            xuejiyidongEntity.setXuejiyidongYesnoTypes(Integer.valueOf(data.get(0)));   //申请状态 要改的
//                            xuejiyidongEntity.setXuejiyidongYesnoText(data.get(0));                    //申请结果 要改的
//                            xuejiyidongEntity.setCreateTime(date);//时间
                            xuejiyidongList.add(xuejiyidongEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        xuejiyidongService.insertBatch(xuejiyidongList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
