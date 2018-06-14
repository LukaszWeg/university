package pl.lukasz.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lukasz.university.entity.ConnectTable;

@Repository
public interface ConnectTableRepository extends JpaRepository<ConnectTable, Long> {
}
