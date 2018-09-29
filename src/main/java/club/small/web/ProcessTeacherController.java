package club.small.web;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Problem;
import club.small.service.ProcessTeacherService;
import jdk.internal.cmm.SystemResourcePressureImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/processTeacher")
public class ProcessTeacherController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private ProcessTeacherService processTeacherService;

    @RequestMapping(value = "/bindEmail", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> bindProcessTeacherEmail(String processTeacherAccount, String email){
        return processTeacherService.bindProcessTeacherEmail(processTeacherAccount, email);
    }

    @RequestMapping(value = "/modifyPassword", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> modifyProcessTeacherPassword(String processTeacherAccount, String password){
        return processTeacherService.modifyProcessTeacherPassword(processTeacherAccount, password);
    }

    @RequestMapping(value = "/getUnprocess", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getUnprocessroblem(String problemType, int pageIndex, int nums, String searchWord, String processTeacherAccount){
        return  processTeacherService.getOrderNumUnprocessProblem(pageIndex, nums, problemType, searchWord, processTeacherAccount);
    }

    @RequestMapping(value = "/makeProcess", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> makeOneProblemToProcess(int problemId, String processCourse){
        return processTeacherService.makeOneProblemToProcess(problemId, processCourse);
    }

    @RequestMapping(value = "/getToTeacher", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getToTeacherProblem(String problemType, int pageIndex, int nums, String searchWord, String processTeacherAccount){
        return  processTeacherService.getOrderNumToTeacherProblem(pageIndex, nums, problemType, searchWord, processTeacherAccount);
    }

    @RequestMapping(value = "/getUnConfirm", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getUnConfirmProblem(String problemType, int pageIndex, int nums, String searchWord, String processTeacherAccount){
        return  processTeacherService.getOrderNumUnconfirmProblem(pageIndex, nums, problemType, searchWord, processTeacherAccount);
    }
}
