package com.jykim.webservice.service.posts;

import com.jykim.webservice.domain.posts.Posts;
import com.jykim.webservice.domain.posts.PostsRepository;
import com.jykim.webservice.web.dto.PostsResponseDto;
import com.jykim.webservice.web.dto.PostsSaveRequestDto;
import com.jykim.webservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("래당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }
}
