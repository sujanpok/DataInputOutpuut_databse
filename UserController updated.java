package com.example.demo.output;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;


/**
 * ユーザー情報 Controller
 */
@Controller
@Slf4j
public class UserController {

    /**
     * ユーザー情報 Service
     */
    @Autowired
    UserService userService;

    /**
     * ユーザー情報一覧画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String displayList(@ModelAttribute("userRequest")User user, Model model) {
        
        return "add";
    }

    /**
     * ユーザー新規登録画面を表示
     * @param model Model
     * @return ユーザー情報一覧画面
     */
  
    
    /**
     * ユーザー新規登録
     * @param userRequest リクエストデータ
     * @param model Model
     * @return ユーザー情報一覧画面
     */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public String create(@ModelAttribute User userRequest, Model model) {
        
    	log.info("{}",userRequest);
    	// ユーザー情報の登録
    	userService.create(userRequest);
    	// ユーザー情報の検索
       List<User> userList= userService.searchAll();
       log.info("{}",userList);
        model.addAttribute("list",userList);
        return "/list";
    }
    
}
