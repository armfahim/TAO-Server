package io.naztech.model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	 private String modifiedDate;
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
	 
	 @OneToMany(cascade = CascadeType.ALL)
	 @JoinColumn(name="id_question_key")
//	 @JoinColumn(name = "id_question_key", referencedColumnName = "id_question_key")
//	 @OneToMany(mappedBy="examQuestion")
	 private List<ExamQuestionOption> examQuestionOptions = new ArrayList<ExamQuestionOption>();

	public int getQuestionKey() {
		return questionKey;
	}

	public void setQuestionKey(int questionKey) {
		this.questionKey = questionKey;
	}

	public int getQuestionVer() {
		return questionVer;
	}

	public void setQuestionVer(int questionVer) {
		this.questionVer = questionVer;
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

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
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

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionSet() {
		return questionSet;
	}

	public void setQuestionSet(String questionSet) {
		this.questionSet = questionSet;
	}

	public List<ExamQuestionOption> getExamQuestionOptions() {
		return examQuestionOptions;
	}

	public void setExamQuestionOptions(List<ExamQuestionOption> examQuestionOptions) {
		this.examQuestionOptions = examQuestionOptions;
	}
	 
}
