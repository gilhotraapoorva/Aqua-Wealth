# Aqua-Wealth
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
