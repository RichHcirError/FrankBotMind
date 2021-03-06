package ru.dpolulyakh.www.model;

import javax.persistence.*;
import java.util.*;

/**
 * @author Denis Polulyakh
 *         14.01.2017.
 */

@Entity
@Table(name="KEY_QUESTION")
public class KeyQuestion {

    @Id
    @Column(name = "ID_QUESTION",unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "QUESTION",nullable = false)
    private String question;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "VALUE_ANSWER",  joinColumns = {
            @JoinColumn(name = "ID_QUESTION", nullable = false, updatable = false) },
            inverseJoinColumns = { @JoinColumn(name = "ID_ANSWER",
                    nullable = false, updatable = false) })
    private Set<ValueAnswer> valueAnswer=new HashSet<ValueAnswer>();

    public KeyQuestion() {

    }

    public KeyQuestion(String question) {
        this.question = question;
    }

    public KeyQuestion(String question, Set<ValueAnswer> valueAnswer) {
        this.question = question;
        this.valueAnswer = valueAnswer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Set<ValueAnswer> getValueAnswer() {
        return valueAnswer;
    }

    public void setValueAnswer(Set<ValueAnswer> valueAnswer) {
        this.valueAnswer = valueAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyQuestion that = (KeyQuestion) o;
        return Objects.equals(question, that.question);
    }

    @Override
    public int hashCode() {
        return question.hashCode();
    }

    @Override
    public String toString() {
        return "KeyQuestion{" +
                "id=" + id +
                ", question='" + question + '\'' +
                '}';
    }
}
