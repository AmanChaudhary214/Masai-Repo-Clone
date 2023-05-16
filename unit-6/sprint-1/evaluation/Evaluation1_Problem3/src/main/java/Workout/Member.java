package Workout;

import java.util.Objects;

public class Member {

	private int memberId;
	private String memberName;
	private int age;
	private String membershipType;	
	
	public Member(int memberId, String memberName, int age, String membershipType) {
		super();
		this.memberId = memberId;
		this.memberName = memberName;
		this.age = age;
		this.membershipType = membershipType;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(age, memberId, memberName, membershipType);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Member other = (Member) obj;
		return age == other.age && memberId == other.memberId && Objects.equals(memberName, other.memberName)
				&& Objects.equals(membershipType, other.membershipType);
	}


	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberName=" + memberName + ", age=" + age + ", membershipType="
				+ membershipType + "]";
	}
	
}
