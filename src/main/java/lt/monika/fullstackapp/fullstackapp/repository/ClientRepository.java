package lt.monika.fullstackapp.fullstackapp.repository;

import lt.monika.fullstackapp.fullstackapp.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
