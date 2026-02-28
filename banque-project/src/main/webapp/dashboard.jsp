<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SEBO — Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Outfit:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --bg:         #111010;
            --surface:    #1a1918;
            --surface2:   #221f1e;
            --amber:      #e8833a;
            --amber-light:#f0a060;
            --amber-dim:  rgba(232,131,58,0.15);
            --text:       #ede9e3;
            --muted:      #7a7066;
            --border:     rgba(232,131,58,0.18);
            --border-soft:rgba(255,255,255,0.06);
        }

        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

        body {
            background-color: var(--bg);
            color: var(--text);
            font-family: 'Outfit', sans-serif;
            font-weight: 300;
            min-height: 100vh;
        }

        body::before {
            content: '';
            position: fixed;
            inset: 0;
            background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 200 200' xmlns='http://www.w3.org/2000/svg'%3E%3Cfilter id='n'%3E%3CfeTurbulence type='fractalNoise' baseFrequency='0.75' numOctaves='4' stitchTiles='stitch'/%3E%3C/filter%3E%3Crect width='100%25' height='100%25' filter='url(%23n)' opacity='0.03'/%3E%3C/svg%3E");
            pointer-events: none;
            z-index: 0;
        }

        .navbar {
            position: relative;
            z-index: 10;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 18px 40px;
            border-bottom: 1px solid var(--border);
            background: var(--surface);
        }
        .navbar-brand {
            font-family: 'Bebas Neue', sans-serif;
            font-size: 1.8rem;
            letter-spacing: 0.12em;
            color: var(--amber);
            text-decoration: none;
        }
        .navbar-links { display: flex; gap: 24px; align-items: center; }
        .navbar-links a {
            font-size: 0.78rem;
            letter-spacing: 0.1em;
            text-transform: uppercase;
            color: var(--muted);
            text-decoration: none;
            transition: color 0.2s;
        }
        .navbar-links a:hover { color: var(--amber); }
        .navbar-links a.active { color: var(--amber); }

        .page-wrap {
            position: relative;
            z-index: 1;
            max-width: 1100px;
            margin: 0 auto;
            padding: 60px 24px;
        }

        .page-header {
            margin-bottom: 40px;
            padding-bottom: 24px;
            border-bottom: 1px solid var(--border-soft);
        }
        .page-header .greeting {
            font-size: 0.75rem;
            letter-spacing: 0.15em;
            text-transform: uppercase;
            color: var(--amber);
            margin-bottom: 6px;
        }
        h1 {
            font-family: 'Bebas Neue', sans-serif;
            font-size: 3rem;
            letter-spacing: 0.05em;
            color: var(--text);
        }
        .page-header .sub {
            margin-top: 8px;
            font-size: 0.85rem;
            color: var(--muted);
        }

        /* Dashboard grid */
        .dash-grid {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
            gap: 20px;
        }

        .dash-card {
            background: var(--surface);
            border: 1px solid var(--border);
            padding: 32px 28px;
            text-decoration: none;
            color: var(--text);
            display: flex;
            flex-direction: column;
            gap: 12px;
            transition: all 0.25s;
            position: relative;
            overflow: hidden;
        }
        .dash-card::before {
            content: '';
            position: absolute;
            top: 0; left: 8%; right: 8%;
            height: 1px;
            background: linear-gradient(90deg, transparent, var(--amber), transparent);
            opacity: 0;
            transition: opacity 0.3s;
        }
        .dash-card::after {
            content: '';
            position: absolute;
            bottom: 0; left: 0; right: 0;
            height: 2px;
            background: var(--amber);
            transform: scaleX(0);
            transition: transform 0.3s;
        }
        .dash-card:hover::before { opacity: 1; }
        .dash-card:hover::after  { transform: scaleX(1); }
        .dash-card:hover {
            transform: translateY(-4px);
            box-shadow: 0 16px 40px rgba(0,0,0,0.5);
            border-color: rgba(232,131,58,0.35);
        }

        .dash-card-icon { font-size: 2rem; line-height: 1; }
        .dash-card-label {
            font-family: 'Bebas Neue', sans-serif;
            font-size: 1.1rem;
            letter-spacing: 0.1em;
            color: var(--amber);
        }
        .dash-card-desc {
            font-size: 0.80rem;
            color: var(--muted);
            line-height: 1.5;
        }

        /* User info strip */
        .user-strip {
            display: flex;
            gap: 32px;
            flex-wrap: wrap;
            background: var(--surface);
            border: 1px solid var(--border);
            padding: 20px 28px;
            margin-bottom: 36px;
            position: relative;
        }
        .user-strip::before {
            content: '';
            position: absolute;
            top: 0; left: 8%; right: 8%;
            height: 1px;
            background: linear-gradient(90deg, transparent, var(--amber), transparent);
        }
        .user-field .field-label {
            font-size: 0.65rem;
            letter-spacing: 0.15em;
            text-transform: uppercase;
            color: var(--muted);
            margin-bottom: 3px;
        }
        .user-field .field-value {
            font-size: 0.9rem;
            color: var(--text);
        }

        @keyframes fadeUp {
            from { opacity: 0; transform: translateY(20px); }
            to   { opacity: 1; transform: translateY(0); }
        }
        .animate { animation: fadeUp 0.7s cubic-bezier(0.16,1,0.3,1) both; }

        @media (max-width: 600px) {
            .navbar { padding: 16px 20px; }
            .page-wrap { padding: 40px 16px; }
            .user-strip { gap: 20px; }
        }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="dashboard" class="navbar-brand">SEBO</a>
    <div class="navbar-links">
        <a href="catalogue">Catalogue</a>
        <a href="cart">Cart</a>
        <a href="commandes">Orders</a>
        <a href="home" style="color:var(--amber);">Sign Out</a>
    </div>
</nav>

<div class="page-wrap animate">

    <div class="page-header">
        <p class="greeting">✦ Welcome back</p>
        <h1>${sessionScope.user.name()}</h1>
        <p class="sub">${sessionScope.user.email()}</p>
    </div>

    <!-- User info strip -->
    <div class="user-strip">
        <div class="user-field">
            <div class="field-label">City</div>
            <div class="field-value">${sessionScope.user.city()}</div>
        </div>
        <div class="user-field">
            <div class="field-label">Address</div>
            <div class="field-value">${sessionScope.user.address()}</div>
        </div>
        <div class="user-field">
            <div class="field-label">Zip</div>
            <div class="field-value">${sessionScope.user.zip()}</div>
        </div>
        <div class="user-field">
            <div class="field-label">Phone</div>
            <div class="field-value">${sessionScope.user.tel()}</div>
        </div>
    </div>

    <!-- Nav cards -->
    <div class="dash-grid">
        <a href="catalogue" class="dash-card">
            <div class="dash-card-icon">🎵</div>
            <div class="dash-card-label">Browse Catalogue</div>
            <div class="dash-card-desc">Explore our full collection of albums and artists</div>
        </a>
        <a href="commandes" class="dash-card">
            <div class="dash-card-icon">📦</div>
            <div class="dash-card-label">My Orders</div>
            <div class="dash-card-desc">View and track all your past orders</div>
        </a>
        <a href="home" class="dash-card">
            <div class="dash-card-icon">🚪</div>
            <div class="dash-card-label">Sign Out</div>
            <div class="dash-card-desc">End your session and return to login</div>
        </a>
    </div>

</div>

</body>
</html>