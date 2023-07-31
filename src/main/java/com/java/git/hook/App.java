package com.java.git.hook;

import com.atlassian.jira.rest.client.api.domain.Issue;
import com.atlassian.jira.rest.client.api.domain.Status;
import com.atlassian.jira.rest.client.api.domain.User;
import com.java.git.hook.api.jira.JIRAService;
import com.java.git.hook.core.GITCommitMsgHook;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Commit Message::"+args[0] +"Branch Name::"+args[1]);
        boolean isBlockedBranches=GITCommitMsgHook.check_valid_commit(args[0],args[1]);
        Issue issue=new JIRAService().getIssue("CBD-1");
        User user=issue.getAssignee();
        String email=user.getEmailAddress();

        String name=user.getName();
        Status status=issue.getStatus();
        String statusname=status.getStatusCategory().getName();
        System.out.println( "email::"+email +"name::"+name);
        if(isBlockedBranches){
            System.exit(1);
        }
        System.out.println( "Program Completed Successfully" );
    }
}
