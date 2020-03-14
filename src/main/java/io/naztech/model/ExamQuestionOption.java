package io.naztech.model;

import java.sql.Date;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="T_EXAM_QUESTION_OPTION")
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
	 private Date modifiedDate;
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
	
	 //@Column(name = "id_question_key")
	 @ManyToOne
	// @JoinColumn(name = "id_question_key",nullable = true)
	 private ExamQuestion examQuestion;

	public int getOptionKey() {
		return optionKey;
	}

	public void setOptionKey(int optionKey) {
		this.optionKey = optionKey;
	}

	public int getOptionVer() {
		return optionVer;
	}

	public void setOptionVer(int optionVer) {
		this.optionVer = optionVer;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getEnvkey() {
		return envkey;
	}

	public void setEnvkey(int envkey) {
		this.envkey = envkey;
	}

	public int getUserModKey() {
		return userModKey;
	}

	public void setUserModKey(int userModKey) {
		this.userModKey = userModKey;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getEventKey() {
		return eventKey;
	}

	public void setEventKey(int eventKey) {
		this.eventKey = eventKey;
	}

	public int getStateKey() {
		return stateKey;
	}

	public void setStateKey(int stateKey) {
		this.stateKey = stateKey;
	}

	public int getActionKey() {
		return actionKey;
	}

	public void setActionKey(int actionKey) {
		this.actionKey = actionKey;
	}

	public String getOptionName() {
		return optionName;
	}

	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}

	public int getIsAnswer() {
		return isAnswer;
	}

	public void setIsAnswer(int isAnswer) {
		this.isAnswer = isAnswer;
	}

	public ExamQuestion getExamQuestion() {
		return examQuestion;
	}

	public void setExamQuestion(ExamQuestion examQuestion) {
		this.examQuestion = examQuestion;
	}
}
