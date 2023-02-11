package com.ohspaces.bookmyspace.repository;

import com.ohspaces.bookmyspace.entity.MembershipEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface MembershipRepository extends JpaRepository<MembershipEntity, Long> {

    @Query(nativeQuery = true, value = "select * from membership where user_id=?0")
    Optional<MembershipEntity> getMembershipByUserId(Long userId);

    @Query(nativeQuery = true, value = "select * from membership where start_date<=:sd OR end_date>=:ed AND product_id=:pi")
    Optional<MembershipEntity> getMembershipBydate(@Param("sd") LocalDateTime startDate,@Param("ed") LocalDateTime endDate,@Param("pi") Long productId);
}
