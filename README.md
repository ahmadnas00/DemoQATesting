<p align="center">
  <img src="https://demoqa.com/images/Toolsqa.jpg" alt="DemoQA Logo" width="300">
</p>
<hr>

<h2 align="center">🧪 DemoQA Testing</h2>
<h3 align="center">By: Ahmad Nassar</h3>



<p>📌 <strong>Developed and implemented an automated test suite for a dynamic web table management interface using Java and Selenium.</strong></p>

<h2>🚀 Technologies Used</h2>
<hr>
<ul>
  <li>☕ <strong>Java</strong></li>
  <li>🧭 <strong>Selenium WebDriver</strong></li>
  <li>✅ <strong>JUnit</strong></li>
  <li>📦 <strong>Maven</strong> (or Gradle)</li>
  <li>🌐 <strong>ChromeDriver</strong></li>
  <li>🧠 <strong>IDE:</strong> IntelliJ IDEA (or any Java IDE)</li>
</ul>

<h2>✨ Features</h2>
<hr>
<ul>
  <li>🔍 <strong>Automated Search Testing:</strong> Verifies search functionality with valid and invalid inputs.</li>
  <li>⏱️ <strong>Dynamic Element Handling:</strong> Waits for elements to appear using explicit waits.</li>
  <li>👻 <strong>Headless Execution:</strong> Tests can run in headless mode for faster execution.</li>
  <li>🔁 <strong>Parameterized Tests:</strong> Supports test cases with various input values.</li>
</ul>

<h2>🛠️ Setup</h2>
<hr>

<h3>📋 Requirements</h3>
<ul>
  <li>Java 17+</li>
  <li>Selenium WebDriver</li>
  <li>JUnit 5 (or TestNG)</li>
  <li>ChromeDriver</li>
  <li>Maven (or Gradle)</li>
  <li>(Optional) IntelliJ IDEA</li>
</ul>

<h3>📦 Installation Steps</h3>
<ol>
  <li><strong>Clone the repository</strong>
    <pre><code class="language-bash">git clone https://github.com/ahmadnas00/DemoQATesting.git
cd DemoQATesting</code></pre>
  </li>
  <li><strong>Install dependencies</strong> (using Maven)
    <pre><code class="language-bash">mvn clean install</code></pre>
  </li>
  <li><strong>Ensure ChromeDriver is set up</strong><br>
    <a href="https://chromedriver.chromium.org/downloads" target="_blank">Download ChromeDriver</a> and add it to your system <code>PATH</code>.
  </li>
  <li><strong>Run the tests</strong>
    <pre><code class="language-bash">mvn test</code></pre>
  </li>
  <li><strong>Generate and view the test report</strong><br>
    This project includes the <strong>Maven Surefire Report Plugin</strong> for generating HTML test reports.<br>
    Run the following command to generate the report:
    <pre><code class="language-bash">mvn surefire-report:report</code></pre>
    The report will be saved under the <code>target/site</code> directory. Open <code>target/site/surefire-report.html</code> in your browser to view the test results.<br>
    <em>Note:</em> You do not need to run <code>mvn test</code> separately before this command, as it compiles, tests, and then generates the report automatically.
  </li>
</ol>


<h3>📊 Test Results Summary</h3>
<table border="1" cellpadding="6" cellspacing="0">
  <thead>
    <tr>
      <th></th>
      <th>Class</th>
      <th>Tests</th>
      <th>Errors</th>
      <th>Failures</th>
      <th>Skipped</th>
      <th>Success Rate</th>
      <th>Time</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td>🌟</td>
      <td><a href="#">SmokeTests</a></td>
      <td>5</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>100%</td>
      <td>24.71 s</td>
    </tr>
    <tr>
      <td>🌤️</td>
      <td><a href="#">UnitTests</a></td>
      <td>30</td>
      <td>0</td>
      <td>0</td>
      <td>0</td>
      <td>100%</td>
      <td>144.6 s</td>
    </tr>
  </tbody>
</table>



<h2>🧩 Improvements</h2>
<hr>
<ul>
  <li>📊 Add detailed test reports with tools like Allure or ExtentReports.</li>
  <li>🔁 Expand the number of test cases for broader coverage. To achieve 100% coverage, include currently untested parts such as the Page View option.</li>
</ul>

<h2>📬 Contact</h2>
<hr>
<p>
  <a href="https://www.linkedin.com/in/ahmad0nassar/" target="_blank">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/linkedin/linkedin-original.svg" width="40px" style="margin-right: 20px;">
  </a>
  <a href="https://github.com/ahmadnas00" target="_blank">
    <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" width="40px">
  </a>
</p>
