package com.masudinn.pam_2087.Model.AllTeam;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseAllTeam {

	@SerializedName("teams")
	@Expose
	private List<DataTeamsItem> teams = null;

	public List<DataTeamsItem> getTeams(){
		return teams;
	}
}