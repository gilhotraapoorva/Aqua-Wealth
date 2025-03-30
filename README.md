# Aqua-Wealth
## Problem Statement

In 2024, India faced extreme weather events on **255 out of 274 days**, causing severe agricultural losses:

- **3.2 million hectares** of crops were damaged, impacting food production and farmer incomes.  
- Over **50% of marginal farmers** lost at least half of their standing crops due to unpredictable weather.  
- **Sugar production** fell below consumption levels for the first time in eight years, with output dropping to **27 million metric tons** against a demand of **29 million tons**, driven by droughts and excessive rainfall in Maharashtra, Karnataka, and Uttar Pradesh.  
- **Cotton production** declined by **7.4%**, increasing imports to **2.5 million bales**, while exports dropped to **1.8 million bales**.  
- **Rapeseed and mustard cultivation** decreased by **10%**, as farmers shifted to wheat and potatoes due to soaring temperatures, heightening India’s dependency on imported vegetable oils.  

These **climate-induced disruptions** threaten farmers’ livelihoods, food security, and economic stability. Despite government support schemes, **insurance payouts and loan approvals remain delayed**, forcing farmers to travel repeatedly from villages to cities, increasing financial strain.  

While platforms like **Groww** enable investments in stocks, **no structured digital investment ecosystem exists** for sustainability-driven agricultural projects, leaving both **farmers and investors disconnected**.  

### The Result?  
Farmers remain **financially vulnerable**, sustainability projects **lack funding**, and **India’s agricultural future is at risk**.  

## Solution  

AquaWealth serves as a project investment and financial support platform specifically designed for the agriculture sector. Unlike traditional investment platforms that focus on companies, AquaWealth enables individuals to invest in agricultural projects, helping farmers who face crop losses, land degradation, and financial constraints. The platform allows users to fund projects aimed at improving water management, sustainable farming, and disaster recovery. It also provides microloans to farmers in need, ensuring they receive financial aid for replanting and equipment restoration. By integrating insurance, loans, and crowdfunding, AquaWealth ensures farmers get timely financial support while investors contribute to sustainable agriculture. Additionally, real-time tracking of investment impact and project success enhances transparency and accountability.
### Key Features

- **Insurance Policy** – Enables farmers to apply for insurance with automated premium calculation.
- **Insurance Claim** – Verifies claim eligibility based on policy details and weather conditions.
- **MicroLoans** – Offers flexible borrowing with interest rates based on collateral selection.
- **Projects and Investments** – Allows users to invest in water-related agricultural projects.
- **Water Credits** – Rewards users for conserving water and managing usage efficiently.


## Process Flows of all features

### 1. Insurance Policy  
- User Logs In  
- User Navigates to Insurance Section  
- User Chooses Insurance Type:  
  - Basic (covers crop damage from natural disasters)  
  - Premium (also covers equipment damage and livestock loss)  
- User Selects Coverage Amount  
- Premium Amount is Auto-Calculated: `Coverage Amount ÷ 30`  
- User Sets Start Date  
- End Date is Auto-Set: `Start Date + 1 year`  
- User Submits the Application  
- Data is Stored in `insurance_policy` table  
- Confirmation is Displayed  

### 2. Insurance Claim  
- User Logs In  
- System Verifies User Credentials  
- User Enters Claim Details (City Name, Claim Date, Claim Amount)  
- System Validates the Claim:  
  - Check 1: Active policy verification via `government_id`  
  - Check 2: Claim date within policy validity period  
  - Check 3: Claim amount ≤ Coverage Amount  
  - Check 4: Weather Condition Verification (via WeatherAPI)  
    - Flood: `Precipitation > 12mm`  
    - Drought: `Precipitation < 0.5mm`  
- Processing the Claim:  
  - If valid, claim is approved and stored in the database  
  - If previous claims exist, total claims must not exceed coverage amount  
- User Receives Confirmation (Approved/Rejected)  

### 3. MicroLoans  
- User Logs In  
- User Navigates to Loan Application  
- User Fills Loan Form:  
  - Loan Amount  
  - Collateral Selection (Yes/No)  
  - Loan Purpose  
  - Loan Term (Years)  
- Interest Calculation:  
  - With Collateral: `12.1% annually`  
  - Without Collateral: `17% annually`  
- Compound Interest is Calculated  
- Loan Submission  
- Loan ID is Generated  
- Total Interest & Amount is Displayed  

### 4. Projects and Investments  
- User Logs In  
- User Navigates to Projects  
- User Selects a Project and Clicks "Start Investing"  
- User Enters Investment Details:  
  - Units to Purchase  
  - Buy Rate (Extracted from `currRate`)  
- System Validates User & Project:  
  - User Account Exists  
  - Project Exists  
- System Calculates Total Investment:  
  - `Total Amount = Units × Buy Rate`  
- System Updates Project Funding (`currAmount` updated)  
- System Saves Investment Record in Database  
- Confirmation is Displayed ("Investment Successful!")  

### 5. Water Credits  
- User Logs In  
- User Adds Water Meter (Meter Number & Details)  
- User Navigates to Water Usage and Clicks "Add Usage Data"  
- User Enters Usage Details (Reading Value & Date)  
- System Automatically Generates Credits & Displays Usage Graph  
- System Calculates Efficiency:  
  - `Daily Usage = (Current Reading - Last Reading) ÷ Days Elapsed`  
  - `Efficiency Score = (200 ÷ Daily Usage) × 100`  
- System Awards Credits (If Score > 100%):  
  - `Credits Earned = (Efficiency Score - 100) × 0.1`  
  - Expiry Date = `Today + 180 Days`  
- System Saves Credit Record & Updates User Balance  
## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-repo/aquawealth.git
   ```
2. Navigate to the project directory:
   ```bash
   cd aquawealth
   ```
3. Install backend dependencies:
   ```bash
   pip install -r requirements.txt
   ```
4. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```
5. Install frontend dependencies:
   ```bash
   npm install
   ```

## How to Run the Project
1. Start the backend server:
   ```bash
   python app.py
   ```
2. Start the Next.js frontend:
   ```bash
   cd frontend
   npm run dev
   ```
3. Open your web browser and go to:
   ```
   http://localhost:3000
   ```
4. Log in or create an account to access the features.
5. Navigate through the platform to explore Insurance, Loans, Investments, and Water Credits.
