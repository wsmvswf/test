package cn.tedu.action;

public class UserVo {
	private String name;
	private Integer age;
	private Integer score;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	@Override
	public String toString() {
		return "UserVo [name=" + name + ", age=" + age + ", score=" + score + "]";
	}
}	
