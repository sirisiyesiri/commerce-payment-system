package com.example.commercepaymentsystem.domain.auth.service;

import com.example.commercepaymentsystem.domain.auth.dto.LoginRequest;
import com.example.commercepaymentsystem.domain.auth.dto.SignupRequest;
import com.example.commercepaymentsystem.domain.auth.dto.SignupResponse;
import com.example.commercepaymentsystem.domain.member.entity.Member;
import com.example.commercepaymentsystem.domain.member.entity.MemberRole;
import com.example.commercepaymentsystem.domain.member.repository.MemberRepository;
import com.example.commercepaymentsystem.global.error.BusinessException;
import com.example.commercepaymentsystem.global.error.ErrorCode;
import com.example.commercepaymentsystem.global.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @Transactional
    public SignupResponse signup(SignupRequest request) {
        if (memberRepository.existsByEmail(request.getEmail())) {
            throw new BusinessException(ErrorCode.DUPLICATE_EMAIL);
        }

        Member member = Member.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .name(request.getName())
                .phone(request.getPhone())
                .role(MemberRole.USER)
                .build();

        memberRepository.save(member);
        return SignupResponse.from(member);
    }

    @Transactional(readOnly = true)
    public String login(LoginRequest request) {
        Member member = memberRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new BusinessException(ErrorCode.INVALID_CREDENTIALS));

        if (!passwordEncoder.matches(request.getPassword(), member.getPassword())) {
            throw new BusinessException(ErrorCode.INVALID_CREDENTIALS);
        }

        return jwtUtil.generateToken(member.getId(), member.getEmail(),  member.getRole().name());
    }
}
