package kg.java.todolist.core.mappers.base;

import kg.java.todolist.core.mappers.CategoryMapper;
import kg.java.todolist.core.mappers.PriorityMapper;
import kg.java.todolist.core.mappers.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MappersConfig {
    @Bean
    public UserMapper buildUserMapper() {
        return new UserMapper();
    }

    @Bean
    public CategoryMapper buildCategoryMapper() {
        return new CategoryMapper();
    }

    @Bean
    public PriorityMapper buildPriorityMapper() {
        return new PriorityMapper();
    }

}
