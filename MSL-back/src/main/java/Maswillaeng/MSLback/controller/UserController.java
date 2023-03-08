package Maswillaeng.MSLback.controller;

import Maswillaeng.MSLback.domain.entity.User;
import Maswillaeng.MSLback.dto.user.request.UserUpdateRequestDto;
import Maswillaeng.MSLback.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor // 이게 멀까
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;


    @GetMapping("/userList")
    public ResponseEntity getUsers(@RequestBody User user){
        Optional<User> responseDto = userService.findByUserId(user.getId());
        return ResponseEntity.ok().build(); //dto로 반환해서 보내주기 .. 이걸 어따 써??? 구
    }

    @GetMapping
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id){
        Optional<User> user = userService.findByUserId(id);//null처리
        return ResponseEntity.ok(user);
    }

    @PutMapping
    public ResponseEntity<Object> updateUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto requestDto) {
        userService.updateUser(id, requestDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Object> deleteByUserId(@PathVariable Long id) {
        userService.deleteByUserId(id);
        return ResponseEntity.ok().build();
    }
}
