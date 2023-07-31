package com.java.git.hook.api.jira;

import com.atlassian.jira.rest.client.api.JiraRestClient;
import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.internal.async.AsynchronousJiraRestClientFactory;
import com.java.git.hook.contants.JiraConstants;

import java.net.URI;

public class JIRAService {
    private final JiraRestClient restClient;

    private JiraRestClient getJiraRestClient() {
        return new AsynchronousJiraRestClientFactory()
                .createWithBasicHttpAuthentication(URI.create(JiraConstants.JIRA_URL), JiraConstants.username, JiraConstants.password);
    }

    public JIRAService() {
        this.restClient = getJiraRestClient();
    }

    public Issue getIssue(String issueKey) {
        return restClient.getIssueClient()
                .getIssue(issueKey)
                .claim();
    }
}
