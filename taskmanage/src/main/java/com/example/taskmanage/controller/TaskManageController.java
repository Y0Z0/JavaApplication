package com.example.taskmanage.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
public class TaskManageController {
    @GetMapping("/greeting")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "task/index";
    }

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/")
    public String index(Model model) {
        String sql = "SELECT * FROM TASKS";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(sql);
        System.out.println(result);
        model.addAttribute("tasks", result);
        return "/task/index";
    }

    @PostMapping("/insert")
    public String insert(@RequestParam("taskId") Integer taskID,
                         @RequestParam("taskName") String taskName,
                         Model model) {

        String insertSql = "INSERT INTO TASKS (id, name) VALUES (?, ?)";
        jdbcTemplate.update(insertSql, taskID, taskName);

        String selectSql = "SELECT * FROM TASKS";
        List<Map<String, Object>> result = jdbcTemplate.queryForList(selectSql);
        System.out.println(result);
        model.addAttribute("tasks", result);
        return "redirect:/"; // リダイレクトして、タスクリストを再表示します
    }
}
