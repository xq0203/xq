package com.compare.demo.Controller;
import com.compare.demo.Entity.EvaluateInfo;
import com.compare.demo.Entity.UserInfo;
import com.compare.demo.Entity.messageInfo;
import com.compare.demo.Mapper.EvaluationMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;
@Controller
@RequestMapping("stu")
public class EvaluationController {
    @Autowired
    private EvaluationMapper evaluationMapper;

//    @GetMapping("/table")
//    public String listing(Model model) {
//        List<EvaluateInfo> Lists = evaluationMapper.getAllEvaluation();
//        model.addAttribute("stu",Lists);
//        return"table";
//    }

    public PageInfo<EvaluateInfo> getAllEvaluation(Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        List<EvaluateInfo> list = evaluationMapper.getAllEvaluation();
        PageInfo<EvaluateInfo> info = new PageInfo<EvaluateInfo>(list);
        return info;
    }

    @RequestMapping("/table")
    public String massage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                          @RequestParam(value = "pageSize",defaultValue = "5") Integer pageSize,
                           Model model){

        PageInfo<EvaluateInfo> Lists= null;
        Lists = getAllEvaluation(pageIndex,pageSize);
        model.addAttribute("stu",Lists);
        return "table";
    }





}