package com.example.commercepaymentsystem.domain.member.service;

import com.example.commercepaymentsystem.domain.member.dto.GetUserResponse;
import com.example.commercepaymentsystem.domain.member.entity.User;
import com.example.commercepaymentsystem.domain.member.repository.UserRepository;
import com.example.commercepaymentsystem.global.error.BusinessException;
import com.example.commercepaymentsystem.global.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public GetUserResponse getMyInfo(Long memberId) {
        User user = userRepository.findById(memberId)
                .orElseThrow(() -> new BusinessException(ErrorCode.MEMBER_NOT_FOUND));
        return GetUserResponse.from(user);
    }
}
