package com.mvc.lab1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.mvc.lab1.entity.StudentScore;

public interface StudentScoreRepository extends JpaRepository<StudentScore, Integer>{
	@Transactional
	@Modifying
	@Query("UPDATE StudentScore s SET s.name =:name WHERE s.id=:id")
	void updateNameById(@Param("id")Integer id, @Param("name")String name);
	
//	@Query("SELECT s.id,s.name,s.chineseScore,s.englishScore,s.mathScore,s.totalScore,"
//			+ "s.averageScore FROM StudentScore s ORDER BY s.totalScore DESC")
//	List<StudentScore> findAllByOrder();
	
//	@Query("SELECT s FROM StudentScore s ORDER BY s.totalScore DESC")
//	List<StudentScore> findAllByOrder();
	
	List<StudentScore> findAllByOrderByTotalScoreDesc();//透過方法名稱,jpa自動生成sql 語句
}
