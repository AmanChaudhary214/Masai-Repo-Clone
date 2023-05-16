package Workout;

import java.util.Objects;

public class WorkoutProgram {

	private int programId;
	private String programName;
	private String programDuration;
	
	public WorkoutProgram(int programId, String programName, String programDuration) {
		super();
		this.programId = programId;
		this.programName = programName;
		this.programDuration = programDuration;
	}
	

	@Override
	public int hashCode() {
		return Objects.hash(programDuration, programId, programName);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		WorkoutProgram other = (WorkoutProgram) obj;
		return Objects.equals(programDuration, other.programDuration) && programId == other.programId
				&& Objects.equals(programName, other.programName);
	}


	@Override
	public String toString() {
		return "WorkoutProgram [programId=" + programId + ", programName=" + programName + ", programDuration="
				+ programDuration + "]";
	}
	
}
