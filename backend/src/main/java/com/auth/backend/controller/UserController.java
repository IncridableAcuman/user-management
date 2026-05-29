package com.auth.backend.controller;

import com.auth.backend.constant.Endpoint;
import com.auth.backend.constant.ResponseMessage;
import com.auth.backend.dto.user.EditUserRequest;
import com.auth.backend.dto.user.UserResponse;
import com.auth.backend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(Endpoint.USER)
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity<UserResponse> getMe(){
        return ResponseEntity.ok(userService.getMe());
    }
    @DeleteMapping
    public ResponseEntity<String> removeUser(@RequestParam Long id){
        userService.removeUser(id);
        return ResponseEntity.ok(ResponseMessage.SUCCESS);
    }
    @GetMapping("/list")
    public ResponseEntity<List<UserResponse>> getList(){
        return ResponseEntity.ok(userService.getList());
    }

    @PatchMapping("/{id}/edit")
    public ResponseEntity<UserResponse> editUser(@PathVariable Long id, @RequestBody EditUserRequest request){
        return ResponseEntity.ok(userService.editUser(id,request));
    }
}
