package com.deloitte.mvc.controller;

import com.deloitte.mvc.model.Todo;
import com.deloitte.mvc.model.TodoStatus;
import com.deloitte.mvc.model.User;
import com.deloitte.mvc.service.TodoService;
import com.deloitte.mvc.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;



@Controller
@RequestMapping(value = "/todo")
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;
    private final UserService userService;

    @RequestMapping(value = "/show-todos", method = GET)
    public String showTodos(Model model) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof UserDetails)
            username = ((UserDetails)principal).getUsername();
        else
            username = principal.toString();
        User u = userService.getUserByName(username).get();
        model.addAttribute("user", u);
        model.addAttribute("todoList", todoService.getAlltodos(u.getId()));
        return "todos";
    }

    @RequestMapping(value = "/updateTodo/{todoId}", method = GET)
    public String updateTodo(@PathVariable int todoId)
    {
        Todo todo = todoService.getTodoById(todoId);
        if (todo.getTodoStatus() == TodoStatus.DONE)
            todo.setTodoStatus(TodoStatus.TODO);
        else
            todo.setTodoStatus(TodoStatus.DONE);
        todoService.updateTodo(todo);
        return "redirect:/todo/show-todos";
    }

    @RequestMapping(value = "/add-todo", method = GET)
    public String showTodoForm() {
        return "todos";
    }

    @RequestMapping(value = "/add-todo", method = POST)
    public String getTodo(@ModelAttribute("todo") Todo todo,
                          @RequestParam(value = "userName") String userName){
        Optional<User> u = userService.getUserByName(userName);
        if (u.isPresent())
            todo.setUser(u.get());
        todoService.add(todo);
        return "redirect:/todo/show-todos";
    }

    @RequestMapping(value = "/delete-by-id/{todoId}", method = GET)
    public String removeTodo(@PathVariable int todoId, Model model){
        todoService.deleteTodoById(todoId);
        return "redirect:/todo/show-todos";
    }
}
