package club.small.web;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.Problem;
import club.small.entity.ProcessTeacher;
import club.small.service.LeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.rowset.spi.SyncResolver;
import java.util.List;

@Controller
@RequestMapping("/leader")
public class LeaderController {
    @Autowired
    private LeaderService leaderService;

    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> modifyOneMessenger(String leaderAccount, String password){
//        System.out.println(chargeAccount);
        return leaderService.modifyOneLeader(leaderAccount, password);
    }

    @RequestMapping(value = "/modifyEmail", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> modifyMessengerEmail(String leaderAccount, String email){
        return leaderService.updateLeaderEmail(leaderAccount, email);
    }

    @RequestMapping(value = "/getUnagree", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getUnagreeProblem(int pageIndex, int nums, String searchWord, String problemType){
        return leaderService.getOrderNumUnagreeProblem(pageIndex, nums, searchWord, problemType);
    }

    @RequestMapping(value = "/agreeProblem", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> makeOneProblemToAgree(int problemId){
        return leaderService.makeOneProblemAgree(problemId);
    }

    @RequestMapping(value = "/addOneProcessTeacher", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> addOneProcessTeacher(String processTeacherAccount, String password, String processType, String processTeacherName){
//        System.out.println(processTeacherName + ", " + processTeacherAccount + ", " + processType + ", " + password);
        System.out.println("问题的类型是:" + processType);
        return leaderService.addOneProcessTeacher(processTeacherAccount, password, processType, processTeacherName);
    }

    @RequestMapping(value = "/getOneProcessTeacher", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<ProcessTeacher> getOneProcessTeacher(String processTeacherAccount){
        return leaderService.getOneProcessTeacher(processTeacherAccount);
    }

    @RequestMapping(value = "/deleteOneProcessTeacher", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> deleteOneProcessTeacher(String processTeacherAccount){
        System.out.println("传进来的值是:" + processTeacherAccount);
        return leaderService.deleteOneProcessTeacher(processTeacherAccount);
    }

    @RequestMapping(value = "/replaceOneCharge", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> replaceOneCharge(String chargeAccount, String chargePassword, String chargeName){
        return leaderService.replaceOneCharge(chargeAccount, chargePassword, chargeName);
    }

    @RequestMapping(value = "/getChargeName", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> getChargeName(){
        return leaderService.getChargeName();
    }
}
