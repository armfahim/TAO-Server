package io.naztech.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="T_EXAM_QUESTION_OPTION")
public class ExamQuestionOption {
	 @Id
	 @Column(name = "id_option_key")
	 @GeneratedValue(strategy =  GenerationType.IDENTITY)
	 private int optionKey;
	 @Column(name = "id_option_ver")
	 private int optionVer;
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
	 @Column(name = "tx_option_name")
	 private String optionName;
	 @Column(name = "is_answer")
	 private int isAnswer;
	 @Column(name = "id_question_key")
	 @ManyToOne
	 private ExamQuestion examQuestion;
}
