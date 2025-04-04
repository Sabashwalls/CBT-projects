Feature: test the codeboard website
  I want to use this template for my feature file
  
  Background: Common for codeboard site
    Given user can able to navigate Codeboardsite
	
	@Parallel
  Scenario: Capture and validate the response time of the website
    Given I navigate to the website
    When I capture the response time and the response time should be less than "100" milliseconds

  Scenario: Check menu items are displayed correctly
    Given user can able to navigate Codeboardsite
    Then I should see the following menu items like Home, offering, Industeries, insights, about us and contact

	@Parallel
  Scenario: Check cookies are displayed correctly
    Given user can able to navigate Codeboardsite
    Then I should see the cookies banner displayed correctly

  Scenario: Verify cookies banner includes Accept and Decline buttons
    Given user can able to navigate Codeboardsite
    And the cookies banner should include an Accept button and Decline button

  Scenario: Verify that the cookie content is displayed correctly
    Given user can able to navigate Codeboardsite
    And the cookies banner should display the correct cookie content

  Scenario: Verify default content on home screen
    Given user can able to navigate Codeboardsite
    Then the default content displayed should be "Automating Insurance Underwriting"
    And the associated picture should be displayed
    And the related content should be visible

  @smoke123
  Scenario: Verify slides on the homepage header
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    Then I should see multiple slides displayed in the header
    And each slide should have content
    And each slide should have a picture
    And each slide should have a View More button

  Scenario: Verify "About Us" section on homepage with content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    Then I should see the About Us section
    And the About Us section should contain the expected content

  Scenario: Verify that the header contains a contact link and redirects to the Contact Us section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    Then I should see a Contact link in the header
    When I click on the Contact link
    Then I should be redirected to the Contact Us section

  @bug
  Scenario: Verify that categories under What We Can Offer are displayed with pictures and content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    Then I should see the What We Can Offer section
    And the section should display the following categories: Insurance, Logistics, Fintech, and ISV

  Scenario: Verify the presence of all items under Why Us
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    Then I should see the Why Us section
    Then I should see the following items displayed like Time to Market, Development Acceleration, Agile, Management Commitment, Flexibility, Lower TCO, Enterprise Experience, Focus

  Scenario: Validate footer slides display content, pictures, and a View More button
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When I scroll to the footer section
    Then I should see multiple slides displayed in the footer
    And each slide should contain like Content, Pictures, View More button

  Scenario: Check if the footer contains the About Us section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    Then I should see the About Us section in the footer
    And the About Us section should contain like Description, Links, Contact Info

  Scenario: Navigate to the Insurance page via Automating Insurance Underwriting and View More
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page

  Scenario: Validate content and pictures displayed on the Insurance page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should see the correct content for the Insurance page
    And all relevant pictures should be displayed

  Scenario: Verify the number of pages under the Insurance section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should see five separate pages listed under the Insurance section

  Scenario: Verify navigation and content accuracy for Sales and Quote page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should be redirected to the correct Sales and Quote page
    And the page should display accurate and relevant content in Sales and Quote page

  Scenario: Verify navigation and content accuracy for Underwriting page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should be redirected to the correct Underwriting page
    And the page should display accurate and relevant content in Underwriting Page

  Scenario: Verify navigation and content accuracy for Underwriting page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should be redirected to the correct Reinsurance page
    And the page should display accurate and relevant content in Reinsurance Page

  Scenario: Verify navigation and content accuracy for Claim Management page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should be redirected to the correct Claim Management page
    And the page should display accurate and relevant content in Claim Management Page

  Scenario: Verify navigation and content accuracy for Broker Management page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More
    Then I should be navigated to the Insurance page
    Then I should be redirected to the correct Broker Management page
    And the page should display accurate and relevant content in Broker Management Page

  Scenario: Navigate to the Fintech page via Accelerated Platform Engineering for Fintech and View More
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in second side
    Then I should be navigated to the Fintech page

  Scenario: Validate content and pictures displayed on the Fintech page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in second side
    Then I should be navigated to the Fintech page
    Then I should see the correct content for the Fintech page
    And all relevant pictures should be displayed in fintech page

  Scenario: Verify the number of pages under the fintech section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in second side
    Then I should be navigated to the Fintech page
    Then I should see 3 separate pages listed under the fintech section

  Scenario: Verify navigation and content accuracy for Lending page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in second side
    Then I should be navigated to the Fintech page
    Then I should be redirected to the correct Lending page
    And the page should display accurate and relevant content in Lending Page

	@smoke123
  Scenario: Verify navigation and content accuracy for Fraud and Compliance page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in second side
    Then I should be navigated to the Fintech page
    Then I should be redirected to the correct Fraud and Compliance page
    And the page should display accurate and relevant content in Fraud and Compliance Page

  Scenario: Verify navigation and content accuracy for capital market page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in second side
    Then I should be navigated to the Fintech page
    Then I should be redirected to the correct capital market page
    And the page should display accurate and relevant content in capital market

  Scenario: Navigate to the App Modernization page using View More
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in third side
    Then I should be navigated to the App Modernization page
    Then I should see the correct content for the App Modernization page
    And all relevant pictures should be displayed in App Modernization page

  Scenario: Navigate to the SuperCharge your Development page using View More
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fourth side
    Then I should be navigated to the SuperCharge your Development page

  Scenario: Validate content and pictures on the Supercharge page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fourth side
    Then I should be navigated to the SuperCharge your Development page
    And The content and pictures on the Supercharge page should be accurate and displayed correctly

  Scenario: Verify the four features under the Functional Features section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fourth side
    Then I should be navigated to the SuperCharge your Development page
    Given The user is on the Functional Features section of the page
    Then The user should see the following features like User Management, Role Management, Data Access Management, LDAP/SSO Medium

  Scenario: Verify the technical features under the Technical Features section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fourth side
    Then I should be navigated to the SuperCharge your Development page
    Given The user is on the Technical Features section of the page
    Then The user should see eight technical features with correct content

  Scenario: Verify the technical features under the Technical Features section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fourth side
    Then I should be navigated to the SuperCharge your Development page
    Given The user is on the Advantages and Metrics section of the page
    Then The user should see five Advantages and Metrics with correct content

  Scenario: Navigate to the Hyper Scaling Business page using View More
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fifth slide
    Then I should be navigated to the Hyper Scaling Business page

  Scenario: Validate content and pictures on the Hyper Scaling Business page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    And I click on View More in fifth slide
    Then I should be navigated to the Hyper Scaling Business page
    And The content and pictures on the Hyper Scaling Business page should be accurate and displayed correctly

  Scenario: Verify navigation to the Product Engineer Service page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Product Engineer Service
    Then The user should be navigated to the corresponding Product Engineer Service page

  Scenario: Validate content and pictures on the Product Engineer Service page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Product Engineer Service
    Then The user should be navigated to the corresponding Product Engineer Service page
    And The content and pictures on the Product Engineer Service page should be accurate and displayed correctly

  Scenario: Verify the number of pages under the Product Engineer Service section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Product Engineer Service
    Then The user should be navigated to the corresponding Product Engineer Service page
    Then I should see 3 separate pages listed under the Product Engineer Service section

  Scenario: Verify navigation to the Application Modernization page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Product Engineer Service
    Then The user should be navigated to the corresponding Product Engineer Service page
    Then The user should be navigated to the Application Modernization page
    And The content and picture on the Application Modernization page should be accurate

  Scenario: Verify navigation to the Accelerated developement page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Product Engineer Service
    Then The user should be navigated to the corresponding Product Engineer Service page
    Then The user should be navigated to the Accelerated developement page
    And The content and picture on the Accelerated developement page should be accurate

  Scenario: Verify navigation to the Engineering page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Product Engineer Service
    Then The user should be navigated to the corresponding Product Engineer Service page
    Then The user should be navigated to the Engineering page
    And The content and picture on the Engineering page should be accurate

  Scenario: Verify navigation to the Cloud Engineering page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Cloud Engineering
    Then The user should be navigated to the corresponding Cloud Engineering page

  Scenario: Validate content and pictures on the Cloud Engineering page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Cloud Engineering
    Then The user should be navigated to the corresponding Cloud Engineering page
    And The content and pictures on the Cloud Engineering page should be accurate and displayed correctly

  Scenario: Verify the number of pages under the Cloud Engineering section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Cloud Engineering
    Then The user should be navigated to the corresponding Cloud Engineering page
    Then I should see 3 separate pages listed under the Cloud Engineering section

  Scenario: Verify navigation to the Cloud Consulting and Migration page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Cloud Engineering
    Then The user should be navigated to the corresponding Cloud Engineering page
    Then The user should be navigated to the Cloud Consulting and Migration page
    And The content and picture on the Cloud Consulting and Migration page should be accurate

  Scenario: Verify navigation to the Hybrid Development page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Cloud Engineering
    Then The user should be navigated to the corresponding Cloud Engineering page
    Then The user should be navigated to the Hybrid Development page
    And The content and picture on the Hybrid Development page should be accurate

  Scenario: Verify navigation to the Native Development page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Cloud Engineering
    Then The user should be navigated to the corresponding Cloud Engineering page
    Then The user should be navigated to the Native Development page
    And The content and picture on the Native Development page should be accurate

  Scenario: Verify navigation to the API Economy and Integration Services page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on API Economy and Integration Services
    Then The user should be navigated to the corresponding API Economy and Integration Services page

  Scenario: Validate content and pictures on the API Economy and Integration Services page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on API Economy and Integration Services
    Then The user should be navigated to the corresponding API Economy and Integration Services page
    And The content and pictures on the API Economy and Integration Services page should be accurate and displayed correct

  Scenario: Verify the number of pages under the API Economy and Integration Services section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on API Economy and Integration Services
    Then The user should be navigated to the corresponding API Economy and Integration Services page
    Then I should see 2 separate pages listed under the API Economy and Integration Services section

  Scenario: Verify navigation to the API Economy page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on API Economy and Integration Services
    Then The user should be navigated to the corresponding API Economy and Integration Services page
    Then The user should be navigated to the API Economy page
    And The content and picture on the API Economy page should be accurate

  Scenario: Verify navigation to the Microservice Architecture page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on API Economy and Integration Services
    Then The user should be navigated to the corresponding API Economy and Integration Services page
    Then The user should be navigated to the Microservice Architecture page
    And The content and picture on the Microservice Architecture page should be accurate

  Scenario: Verify navigation to the Testing and Services page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Testing and Services
    Then The user should be navigated to the Testing and Services pages

  Scenario: Validate content and pictures on the Testing and Services page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Testing and Services
    Then The user should be navigated to the Testing and Services pages
    And The content and pictures on the Testing and Services page should be accurate and displayed correct

  Scenario: Verify navigation to the Devops page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Devops
    Then The user should be navigated to the Devops pages

  Scenario: Validate content and pictures on the Devops page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Devops
    Then The user should be navigated to the Devops pages
    And The content and pictures on the Devops page should be accurate and displayed correct

	@smoke123
  Scenario: Verify navigation to the Data Engineering and Intelligence page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages

  Scenario: Validate content and pictures on the Data Engineering and Intelligence page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    And The content and pictures on the Data Engineering and Intelligence page should be accurate and displayed correct

  Scenario: Verify the number of pages under the Data Engineering and Intelligence section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages
    Then I should see 5 separate pages listed under the Data Engineering and Intelligence section

  Scenario: Verify navigation to the Data Streaming and Transformation page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages
    Then The user should be navigated to the Data Streaming and Transformation page
    And The content and picture on the Data Streaming and Transformation page should be accurate

  Scenario: Verify navigation to the Analytics page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages
    Then The user should be navigated to the Analytics page
    And The content and picture on the Analytics page should be accurate

  Scenario: Verify navigation to the AI/ML page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages
    Then The user should be navigated to the AI/ML page
    And The content and picture on the AI/ML page should be accurate

  Scenario: Verify navigation to the Data visualization page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages
    Then The user should be navigated to the Data visualization page
    And The content and picture on the Data visualization page should be accurate

  Scenario: Verify navigation to the Hyper Automation page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Data Engineering and Intelligence
    Then The user should be navigated to the Data Engineering and Intelligence pages
    Then The user should be navigated to the Hyper Automation page
    And The content and picture on the Hyper Automation page should be accurate

  Scenario: Verify navigation to the Insurance page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Insurance from the industries dropdown
    Then The user should be navigated to the Insurance pages

  Scenario: Verify navigation to the Fintech page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Fintech from the industries dropdown
    Then The user should be navigated to the Fintech pages

  Scenario: Verify navigation to the ISV page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on ISV from the industries dropdown
    Then The user should be navigated to the ISV pages

  Scenario: Validate content and pictures on the ISV page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on ISV from the industries dropdown
    Then The user should be navigated to the ISV pages
    And The content and pictures on the ISV page should be accurate and displayed correct

  Scenario: Verify the number of pages under the ISV section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on ISV from the industries dropdown
    Then The user should be navigated to the ISV pages
    Then The user should be navigated to the ISV pages
    Then I should see 3 separate pages listed under the ISV section

  Scenario: Verify navigation to the Architecture and Evaluation service page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on ISV from the industries dropdown
    Then The user should be navigated to the ISV pages
    Then The user should be navigated to the Architecture and Evaluation service page
    And The content and picture on the Architecture and Evaluation service page should be accurate

  Scenario: Verify navigation to the Extended Engineering service page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on ISV from the industries dropdown
    Then The user should be navigated to the ISV pages
    Then The user should be navigated to the Extended Engineering service page
    And The content and picture on the Extended Engineering service page should be accurate

  Scenario: Verify navigation to the Co-Owned R and D Labs page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on ISV from the industries dropdown
    Then The user should be navigated to the ISV pages
    Then The user should be navigated to the Co-Owned R and D Labs page
    And The content and picture on the Co-Owned R and D Labs page should be accurate

  Scenario: Verify navigation to the Logistics page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Logistics from the industries dropdown
    Then The user should be navigated to the Logistics pages

  Scenario: Validate content and pictures on the Logistics page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Logistics from the industries dropdown
    Then The user should be navigated to the Logistics pages
    And The content and pictures on the Logistics page should be accurate and displayed correct

  Scenario: Verify the number of pages under the Logistics section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Logistics from the industries dropdown
    Then The user should be navigated to the Logistics pages
    Then I should see 2 separate pages listed under the Logistics section

  Scenario: Verify navigation to the Aggregator Solution page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Logistics from the industries dropdown
    Then The user should be navigated to the Logistics pages
    Then The user should be navigated to the Aggregator Solution page
    And The content and picture on the Aggregator Solution page should be accurate

  Scenario: Verify navigation to the Logistic Solution page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Logistics from the industries dropdown
    Then The user should be navigated to the Logistics pages
    Then The user should be navigated to the Logistic Solution page
    And The content and picture on the Logistic Solution page should be accurate

  Scenario: Verify navigation to the Payment page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Payment from the industries dropdown
    Then The user should be navigated to the Payment pages

  Scenario: Validate content and pictures on the Payment page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Payment from the industries dropdown
    Then The user should be navigated to the Payment pages
    And The content and pictures on the Payment page should be accurate and displayed correct

  Scenario: Verify the number of pages under the Payment section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Payment from the industries dropdown
    Then The user should be navigated to the Payment pages
    Then I should see 2 separate pages listed under the Payment section

  Scenario: Verify navigation to the payment page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Payment from the industries dropdown
    Then The user should be navigated to the Payment pages
    Then The user should be navigated to the Payment subpage page
    And The content and picture on the Payment page should be accurate

  Scenario: Verify navigation to the Chargeback page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Payment from the industries dropdown
    Then The user should be navigated to the Payment pages
    Then The user should be navigated to the Chargeback subpage page
    And The content and picture on the Chargeback page should be accurate

  @new
  Scenario: Verify navigation to the Case studies page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages

  Scenario: Validate content and pictures on the Payment page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    And The content and picture on the Case studies page should be accurate

  Scenario: Verify the number of pages under the Case studies section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then I should see 13 separate pages listed under the Case studies section

  Scenario: Verify navigation to the Automating and Reducing Risk in Insurance Underwriting page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Automating and Reducing Risk in Insurance Underwriting subpage
    And The content and picture on the Automating and Reducing Risk in Insurance Underwriting page should be accurate

  Scenario: Verify navigation to the Credit Risk with Precision page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Credit Risk with Precision subpage
    And The content and picture on the Credit Risk with Precision page should be accurate

  Scenario: Verify navigation to the Platform Engineering and Development Acceleration page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Platform Engineering and Development Acceleration subpage
    And The content and picture on the Platform Engineering and Development Acceleration page should be accurate

  Scenario: Verify navigation to the Rapid Portal Development; minimizing failures and maximize ROI page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Rapid Portal Development; minimizing failures and maximize ROI subpage
    And The content and picture on the Rapid Portal Development; minimizing failures and maximize ROI page should be accurate

  Scenario: Verify navigation to the Re-Architecting and Modernizing to cater fast growing Insurance Market page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Re-Architecting and Modernizing to cater fast growing Insurance Market subpage
    And The content and picture on the Re-Architecting and Modernizing to cater fast growing Insurance Market page should be accurate

  Scenario: Verify navigation to the  Cloud Native Development enabled real time visibility and complex integrations page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the  Cloud Native Development enabled real time visibility and complex integrations subpage
    And The content and picture on the  Cloud Native Development enabled real time visibility and complex integrations page should be accurate

  Scenario: Verify navigation to the  Hybrid Cloud Development for a Core Banking Solution page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the  Hybrid Cloud Development for a Core Banking Solution subpage
    And The content and picture on the  Hybrid Cloud Development for a Core Banking Solution page should be accurate

  Scenario: Verify navigation to the API Integration made easy page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the  API Integration made easy subpage
    And The content and picture on the API Integration made easy page should be accurate

  Scenario: Verify navigation to the Open-source API integration bringing flexibility and agility page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the  Open-source API integration bringing flexibility and agility subpage
    And The content and picture on the Open-source API integration bringing flexibility and agility page should be accurate

  Scenario: Verify navigation to the Extended Testing as Service Team page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Extended Testing as Service Team subpage
    And The content and picture on the Extended Testing as Service Team page should be accurate

  Scenario: Verify navigation to the Automation Testing fostering agility page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Automation Testing fostering agility subpage
    And The content and picture on the Automation Testing fostering agility page should be accurate

  Scenario: Verify navigation to the CI/CD Automation and Process Streamlining page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the CI/CD Automation and Process Streamlining subpage
    And The content and picture on the CI/CD Automation and Process Streamlining page should be accurate

  Scenario: Verify navigation to the Data Visualization for Revenue Consolidation page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on case studies from the insights dropdown
    Then The user should be navigated to the Case studies pages
    Then The user should be navigated to the Data Visualization for Revenue Consolidation subpage
    And The content and picture on the Data Visualization for Revenue Consolidation page should be accurate

  Scenario: Verify navigation to the white paper page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages

  Scenario: Validate content and pictures on the white paper page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    And The content and picture on the white paper page should be accurate

  Scenario: Verify the number of pages under the white paper section
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then I should see 10 separate pages listed under the white paper section

  Scenario: Verify navigation to the Leveraging an Extended Engineering Team for Insuretech Innovation page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Leveraging an Extended Engineering Team for Insuretech Innovation subpage
    And The content and picture on the Leveraging an Extended Engineering Team for Insuretech Innovation page should be accurate

  Scenario: Verify navigation to the Easy to start, even easier to implement page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Easy to start, even easier to implement subpage
    And The content and picture on the Easy to start, even easier to implement page should be accurate

  Scenario: Verify navigation to the How we approached successful projects page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the How we approached successful projects subpage
    And The content and picture on the How we approached successful projects page should be accurate

  Scenario: Verify navigation to the Rapid Portal Development page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Rapid Portal Development subpage
    And The content and picture on the Rapid Portal Development page should be accurate

  Scenario: Verify navigation to the Unlocking the Power of Application Modernization: Transform Your Business for the Digital Era page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Unlocking the Power of Application Modernization: Transform Your Business for the Digital Era subpage
    And The content and picture on the Unlocking the Power of Application Modernization: Transform Your Business for the Digital Era page should be accurate

  Scenario: Verify navigation to the Solving Problems during Product Life Cycle for Software Vendors page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Solving Problems during Product Life Cycle for Software Vendors subpage
    And The content and picture on the Solving Problems during Product Life Cycle for Software Vendors page should be accurate

  Scenario: Verify navigation to the Grow with the growth page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Grow with the growth subpage
    And The content and picture on the SGrow with the growth page should be accurate

  Scenario: Verify navigation to the How Fruitful Are AI & Blockchain In Insurance Claims Management? page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the How Fruitful Are AI & Blockchain In Insurance Claims Management? subpage
    And The content and picture on the How Fruitful Are AI & Blockchain In Insurance Claims Management? page should be accurate

  Scenario: Verify navigation to the Identifying Credit Card Frauds Using AI page and its content
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on white paper from the insights dropdown
    Then The user should be navigated to the white paper pages
    Then The user should be navigated to the Identifying Credit Card Frauds Using AI subpage
    And The content and picture on the Identifying Credit Card Frauds Using AI page should be accurate

  Scenario: Validate content and pictures on the Culture under about us page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on culture from the about us dropdown
    Then The user should be navigated to the culture page
    And The content and picture on the culture page should be accurate

  Scenario: Validate content and pictures on the Work with us under about us page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Work with us from the about us dropdown
    Then The user should be navigated to the Work with us page
    And The content and picture on the Work with us page should be accurate

  Scenario: Validate content and pictures on the Tools and Technology under about us page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Tools and Technology from the about us dropdown
    Then The user should be navigated to the Tools and Technology page
    And The content and picture on the Tools and Technology page should be accurate

  Scenario: Validate content and pictures on the Engagement Model under about us page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Engagement Model from the about us dropdown
    Then The user should be navigated to the Engagement Model page
    And The content and picture on the Engagement Model page should be accurate

  Scenario: Validate content and pictures on the Team under about us page
    Given user can able to navigate Codeboardsite
    And I accept the cookies
    When The user clicks on Team from the about us dropdown
    Then The user should be navigated to the Team page
    And The content and picture on the Team page should be accurate
