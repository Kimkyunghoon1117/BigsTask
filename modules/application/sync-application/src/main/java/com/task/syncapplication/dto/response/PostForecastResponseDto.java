package com.task.syncapplication.dto.response;

import com.task.syncapplication.dto.response.common.ResponseCode;
import com.task.syncapplication.dto.response.common.ResponseDto;
import com.task.syncapplication.dto.response.common.ResponseMessage;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostForecastResponseDto extends ResponseDto {

    private PostForecastResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostForecastResponseDto> success(){
        PostForecastResponseDto result = new PostForecastResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
