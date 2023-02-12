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

    @Query(nativeQuery = true, value = "select * from membership where user_id=:userId and is_active=0")
    Optional<MembershipEntity> getMembershipByUserId(@Param("userId") Long userId);

    @Query(nativeQuery = true, value = "select * from membership where end_date>=:sd AND product_id=:pi AND is_active=1")
    Optional<MembershipEntity> getMembershipBydate(@Param("sd") LocalDateTime startDate,@Param("pi") Long productId);
}
