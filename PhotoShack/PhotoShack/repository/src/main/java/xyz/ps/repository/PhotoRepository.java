package xyz.ps.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.ps.model.PhotoModel;

@Repository
public interface PhotoRepository extends JpaRepository<PhotoModel, Integer> {
}