package cn.example.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthorDto {
    String name;

    List<String> hobby;

    String birthday;

    String description;

    Sex sex;
}
