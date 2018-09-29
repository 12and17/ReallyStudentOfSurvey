package club.small.web;

import club.small.dto.Empty;
import club.small.dto.Result;
import club.small.entity.ClassInfo;
import club.small.entity.Problem;
import club.small.service.MessengerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/messenger")
public class MessengerController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private MessengerService messengerService;

    @RequestMapping(value = "/sumbit", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
//    public Result<Empty> sumbitOneProblem(String messengerAccount, String problemType, String problemDiscrible){
    public Result<Empty> sumbitOneProblem(String messengerAccount, String problemType, String problemDiscrible){
//        System.out.println("账号：" + messengerAccount + problemDiscrible + problemType);
        return messengerService.sumbitOnrProblem(messengerAccount, problemDiscrible, problemType);
    }

    @RequestMapping(value = "/select", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getSelectProblem(String messengerAccount, String describeWord){
        System.out.println(messengerAccount + describeWord);
        return messengerService.getSelectProblem(messengerAccount, describeWord);
    }

    @RequestMapping(value = "/selectUnsubmit", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getSelectUnsumbitProblem(String messengerAccount, String describeWord){
//        System.out.println(messengerAccount + describeWord);
        return messengerService.getSelectUnsubmitProblem(messengerAccount, describeWord);
    }

    @RequestMapping(value = "/modify", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> modifyOneMessenger(String messengerAccount, String password){
        return messengerService.modifyOneMessenger(messengerAccount, password);
    }

    @RequestMapping(value = "/getVerification", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> getVerificationCode(String mailAccount){
        System.out.println(mailAccount);
        return messengerService.getVerificationCode(mailAccount);
    }

    @RequestMapping(value = "/modifyEmail", method = RequestMethod.POST, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<Empty> modifyMessengerEmail(String messengerAccount, String email){
        return messengerService.updateMessengerEmail(messengerAccount, email);
    }

    @RequestMapping(value = "/getAlreadyProcess", method = RequestMethod.GET, produces = {
            "application/json; charset=utf-8" })
    @ResponseBody
    public Result<List<Problem>> getOrderNumAlreadyProcessProblem(int pageIndex, int nums, String searchWord, String processTeacherAccount){
        return messengerService.getOrderNumAlreadyProcessProblem(pageIndex, nums, searchWord, processTeacherAccount);
    }
}
