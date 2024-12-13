package edu.eci.cvds.NotificationService.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "loan_history")
public class LoanHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "record_date", nullable = false)
    private LocalDate recordDate;

    @Column(name = "copy_state", nullable = false)
    private String copyState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "loan_id", nullable = false)
    @JsonBackReference
    private Loan loan;

    public LoanHistory(LocalDate recordDate, String copyState) {
        this.recordDate = recordDate;
        this.copyState = copyState;
    }

    public LoanHistory(LocalDate recordDate, String copyState, Loan loan) {
        this.recordDate = recordDate;
        this.copyState = copyState;
        this.loan = loan;
    }
}