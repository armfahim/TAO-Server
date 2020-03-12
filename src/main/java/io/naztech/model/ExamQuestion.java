package io.naztech.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="T_EXAM_QUESTION")
public class ExamQuestion {
	 @Id
	 @Column(name = "id_question_key")
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private int questionKey;
	 @Column(name = "id_question_ver")
	 private int questionVer;
	 @Column(name = "is_active")
	 private int isActive;
	 @Column(name = "id_env_key")
	 private int envkey;
	 @Column(name = "id_user_mod_key")
	 private int userModKey;
	 @Column(name = "dtt_mod")
	 private LocalDateTime modifiedDate;
	 @Column(name = "id_event_key")
	 private int eventKey;
	 @Column(name = "id_state_key")
	 private int stateKey;
	 @Column(name = "id_action_key")
	 private int actionKey;
	 @Column(name = "tx_question")
	 private String question;
	 @Column(name = "tx_question_set")
	 private String questionSet; 
	 @OneToMany(mappedBy="examQuestion")
	 private List<ExamQuestionOption> examQuestionOptions = new ArrayList<ExamQuestionOption>();
}
