package com.example.library.repositories;

import com.example.library.entities.CupBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface CupBoardRepository extends JpaRepository<CupBoard,Long> {
}
