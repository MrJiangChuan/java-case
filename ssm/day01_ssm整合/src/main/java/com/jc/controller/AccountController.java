package com.jc.controller;

import com.jc.entity.Account;
import com.jc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @RequestMapping("/findAll")
    public String findAll(Model model){
        List<Account> list = accountService.findAll();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping("/insert")
    public String insert(Account account){
        accountService.insert(account);
        return "redirect:/account/findAll";
    }

    @RequestMapping("/update")
    public String update(Account account){
        accountService.update(account);
        return "redirect:/account/findAll";
    }


    @RequestMapping("/delete")
    public String delete(Integer id){
        accountService.delete(id);
        return "redirect:/account/findAll";
    }
}
