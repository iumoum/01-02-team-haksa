package com.cafe24.iumium;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cafe24.iumium.manage.lecture.dto.AssignmentForEvaluateCode;
import com.cafe24.iumium.manage.lecture.dto.GradingCriteriaCode;
import com.cafe24.iumium.manage.lecture.dto.QuestionForEvaluateLectureCode;
import com.cafe24.iumium.manage.lecture.dto.SubjectCode;
import com.cafe24.iumium.manage.lecture.dto.TypeOfCompletionCode;
import com.cafe24.iumium.manage.lecture.service.ManageLectureCodeService;

@Controller
public class ManageLectureController {
    @Autowired
    private ManageLectureCodeService lectureCodeService;
    
    //이수구분 코드 관리
    @RequestMapping(value="/lecture/codes/Toc", method = RequestMethod.GET)
    public String tocList(Model model) {
        List<TypeOfCompletionCode> list = lectureCodeService.selectManageLectureTocList();
        model.addAttribute("list", list);
        return "lectureCode/typeOfCompletionCode";
    }
    
    //과목 코드 관리
    @RequestMapping(value="/lecture/codes/subject", method = RequestMethod.GET)
    public String subjectList(Model model) {
        List<SubjectCode> list = lectureCodeService.selectManageLectureSubjectList();
        model.addAttribute("list", list);
        return "lectureCode/subjectCode";
    }
    
    //강의평가 항목 코드 관리
    @RequestMapping(value="/lecture/codes/Qfel", method = RequestMethod.GET)
    public String questionForEvaluateLectureList(Model model) {
        List<QuestionForEvaluateLectureCode> list = lectureCodeService.selectManageLectureQfelList();
        model.addAttribute("list", list);
        return "lectureCode/questionForEvaluateLectureCode";
    }
    
    //강의별 평가항목 배정 코드 관리
    @RequestMapping(value="/lecture/codes/Afe", method = RequestMethod.GET)
    public String assignmentForEvaluateList(Model model) {
        List<AssignmentForEvaluateCode> list = lectureCodeService.selectManageLectureAfeList();
        model.addAttribute("list", list);
        return "lectureCode/assignmentForEvaluateCode";
    }
    
    //성적평가 기준 코드 관리
    @RequestMapping(value="/lecture/codes/Gc", method = RequestMethod.GET)
    public String gradingCriteriaList(Model model) {
        List<GradingCriteriaCode> list = lectureCodeService.selectManageLectureGccList();
        model.addAttribute("list", list);
        return "lectureCode/gradingCriteriaCode";
    }
}