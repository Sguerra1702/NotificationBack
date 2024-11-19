package edu.eci.cvds.NotificationService.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import edu.eci.cvds.NotificationService.Model.Loan;

public interface LoanRepository extends MongoRepository<Loan, String>{

    
}