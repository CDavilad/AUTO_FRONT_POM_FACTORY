Feature: Ticket Management System E2E Flow

  Background:
    Given the admin is on the login page
    When the admin enters email "admin@sofkau.com" and password "Admin@SofkaU_2026!"
    And the admin submits the login form
    Then the admin should see the tickets dashboard

  Scenario: Admin creates and manages a support ticket
    When the admin navigates to create ticket page
    And the admin enters ticket title "Test Automation Ticket"
    And the admin enters ticket description "This is a test automation ticket created for testing purposes"
    And the admin submits the ticket form
    Then the admin should see the new ticket in the dashboard
    When the admin clicks on the created ticket
    Then the admin should see the ticket detail page
    When the admin changes the priority to "HIGH"
    And the admin saves the priority change
    Then the priority should be updated successfully
