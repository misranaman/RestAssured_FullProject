package pojo.jira;

public class Payload {

	String summary;
	String description;
	IssueType issueType;
	Projects project;

	public Payload(String summary, String description, IssueType issueType, Projects project) {

		this.summary = summary;
		this.description = description;
		this.issueType = issueType;
		this.project = project;

	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public IssueType getIssueType() {
		return issueType;
	}

	public void setIssueType(IssueType issueType) {
		this.issueType = issueType;
	}

	public Projects getProject() {
		return project;
	}

	public void setProject(Projects project) {
		this.project = project;
	}

}
