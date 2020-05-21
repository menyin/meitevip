package com.springboot.base.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class Hi {
    /**
     * 测试fremark模板整合
     * @param model
     * @return
     */
    @RequestMapping("/hi")
    public String index(Model model){
        model.addAttribute("name","埃克斯好特曼");
        return "hi";
    }

    /**
     * 测试异常处理handler
     * @param model
     * @return
     * @apiNote
     *  如果要统一异常处理就不能try-catch
     */
    @RequestMapping("/e")
    public String testExeception(Model model){
        int i=1/0;
        return "hi";
    }

    /**
     * 根据特定异常做特定处理
     * @param model
     * @return
     * @throws MyExeception
     * @apiNote
     *  如果要统一异常处理就不能try-catch
     */
    @RequestMapping("/mye")
    public String testMyExeception(Model model) throws MyExeception {
       if(true){
           throw new MyExeception("社会太残酷");
       }else{
           return "hi";
       }
    }


}
