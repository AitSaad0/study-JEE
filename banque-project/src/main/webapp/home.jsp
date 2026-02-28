<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SEBO — Home</title>
    <meta charset="UTF-8">
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

/* Navbar */
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

/* Page wrapper */
.page-wrap {
    position: relative;
    z-index: 1;
    max-width: 1100px;
    margin: 0 auto;
    padding: 40px 24px;
}

/* Headings */
h1, h2 {
    font-family: 'Bebas Neue', sans-serif;
    letter-spacing: 0.05em;
    color: var(--text);
}
h1 { font-size: 2.6rem; margin-bottom: 6px; }
h2 { font-size: 1.6rem; margin-bottom: 20px; color: var(--amber); }

/* Card */
.card {
    background: var(--surface);
    border: 1px solid var(--border);
    padding: 48px 52px;
    position: relative;
}
.card::before {
    content: '';
    position: absolute;
    top: 0; left: 8%; right: 8%;
    height: 1px;
    background: linear-gradient(90deg, transparent, var(--amber), transparent);
}

/* Centered card layout */
.center-layout {
    min-height: 100vh;
    display: flex;
    align-items: center;
    justify-content: center;
    padding: 40px 24px;
    position: relative;
    z-index: 1;
}

.form-card {
    background: var(--surface);
    border: 1px solid var(--border);
    padding: 48px 52px;
    width: 100%;
    max-width: 480px;
    position: relative;
    animation: fadeUp 0.7s cubic-bezier(0.16,1,0.3,1) both;
}
.form-card::before {
    content: '';
    position: absolute;
    top: 0; left: 8%; right: 8%;
    height: 1px;
    background: linear-gradient(90deg, transparent, var(--amber), transparent);
}

.brand-header {
    text-align: center;
    margin-bottom: 32px;
}
.brand-header .brand-name {
    font-family: 'Bebas Neue', sans-serif;
    font-size: 2rem;
    letter-spacing: 0.2em;
    color: var(--amber);
}
.brand-header .page-title {
    font-family: 'Bebas Neue', sans-serif;
    font-size: 1.3rem;
    letter-spacing: 0.1em;
    color: var(--text);
    margin-top: 4px;
}
.brand-header .divider {
    width: 36px;
    height: 2px;
    background: var(--amber);
    margin: 12px auto 0;
    opacity: 0.6;
}

/* Form elements */
label {
    display: block;
    font-size: 0.72rem;
    letter-spacing: 0.1em;
    text-transform: uppercase;
    color: var(--muted);
    margin-bottom: 6px;
    margin-top: 18px;
}
input[type="text"],
input[type="password"],
input[type="email"],
select {
    width: 100%;
    padding: 11px 14px;
    background: var(--surface2);
    border: 1px solid var(--border-soft);
    color: var(--text);
    font-family: 'Outfit', sans-serif;
    font-size: 0.9rem;
    outline: none;
    transition: border-color 0.2s;
    border-radius: 2px;
}
input:focus, select:focus {
    border-color: var(--amber);
    box-shadow: 0 0 0 3px var(--amber-dim);
}
input::placeholder { color: var(--muted); font-size: 0.85rem; }

/* Buttons */
.btn {
    display: inline-block;
    padding: 12px 22px;
    font-family: 'Outfit', sans-serif;
    font-size: 0.78rem;
    font-weight: 500;
    letter-spacing: 0.1em;
    text-transform: uppercase;
    text-decoration: none;
    cursor: pointer;
    border: none;
    transition: all 0.25s ease;
    border-radius: 2px;
}
.btn-primary { background: var(--amber); color: #111; }
.btn-primary:hover {
    background: var(--amber-light);
    transform: translateY(-2px);
    box-shadow: 0 6px 20px rgba(232,131,58,0.3);
}
.btn-secondary {
    background: transparent;
    color: var(--text);
    border: 1px solid var(--border-soft);
}
.btn-secondary:hover {
    border-color: var(--amber);
    color: var(--amber);
    transform: translateY(-2px);
}
.btn-block { width: 100%; text-align: center; }
.btn-sm { padding: 7px 14px; font-size: 0.72rem; }

/* Link */
a.link {
    color: var(--amber);
    text-decoration: none;
    font-size: 0.82rem;
}
a.link:hover { text-decoration: underline; }

/* Error */
.error-msg {
    background: rgba(192,57,43,0.15);
    border: 1px solid rgba(192,57,43,0.4);
    color: #e74c3c;
    padding: 10px 14px;
    font-size: 0.82rem;
    margin-bottom: 16px;
    border-radius: 2px;
}

/* Table */
table { width: 100%; border-collapse: collapse; margin-top: 24px; }
th {
    background: var(--surface2);
    font-family: 'Bebas Neue', sans-serif;
    font-size: 0.85rem;
    letter-spacing: 0.1em;
    color: var(--amber);
    padding: 12px 16px;
    text-align: left;
    border-bottom: 1px solid var(--border);
}
td {
    padding: 12px 16px;
    border-bottom: 1px solid var(--border-soft);
    font-size: 0.88rem;
    color: var(--text);
}
tr:hover td { background: var(--surface2); }

/* Filter bar */
.filter-bar {
    display: flex;
    align-items: center;
    gap: 14px;
    background: var(--surface);
    padding: 16px 20px;
    border: 1px solid var(--border);
    flex-wrap: wrap;
}
.filter-bar label { margin: 0; white-space: nowrap; }
.filter-bar select { width: auto; flex: 1; min-width: 180px; }

/* Page header */
.page-header {
    margin-bottom: 28px;
    padding-bottom: 20px;
    border-bottom: 1px solid var(--border-soft);
}
.page-header .greeting {
    font-size: 0.75rem;
    letter-spacing: 0.15em;
    text-transform: uppercase;
    color: var(--amber);
    margin-bottom: 6px;
}

/* Dashboard cards */
.dash-grid {
    display: grid;
    grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
    gap: 16px;
    margin-bottom: 36px;
}
.dash-card {
    background: var(--surface);
    border: 1px solid var(--border);
    padding: 28px 24px;
    text-decoration: none;
    color: var(--text);
    display: flex;
    flex-direction: column;
    gap: 10px;
    transition: all 0.25s;
    position: relative;
    overflow: hidden;
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
.dash-card:hover::after { transform: scaleX(1); }
.dash-card:hover { transform: translateY(-3px); box-shadow: 0 12px 32px rgba(0,0,0,0.4); }
.dash-card-icon {
    font-size: 1.6rem;
    line-height: 1;
}
.dash-card-label {
    font-family: 'Bebas Neue', sans-serif;
    font-size: 1rem;
    letter-spacing: 0.1em;
    color: var(--amber);
}
.dash-card-desc {
    font-size: 0.78rem;
    color: var(--muted);
}

/* Detail page */
.detail-layout {
    display: grid;
    grid-template-columns: 220px 1fr;
    gap: 40px;
    align-items: start;
}
.detail-cover {
    width: 100%;
    aspect-ratio: 1;
    object-fit: cover;
    border: 1px solid var(--border);
}
.detail-cover-placeholder {
    width: 100%;
    aspect-ratio: 1;
    background: var(--surface2);
    border: 1px solid var(--border);
    display: flex;
    align-items: center;
    justify-content: center;
}
.detail-field {
    margin-bottom: 14px;
}
.detail-field .field-label {
    font-size: 0.68rem;
    letter-spacing: 0.15em;
    text-transform: uppercase;
    color: var(--muted);
    margin-bottom: 4px;
}
.detail-field .field-value {
    font-size: 1rem;
    color: var(--text);
    font-weight: 400;
}
.detail-field .field-value.price {
    font-family: 'Bebas Neue', sans-serif;
    font-size: 1.8rem;
    color: var(--amber);
    letter-spacing: 0.05em;
}
.detail-actions {
    display: flex;
    gap: 12px;
    margin-top: 28px;
    flex-wrap: wrap;
}

/* Footer */
.bottom-note {
    text-align: center;
    margin-top: 20px;
    font-size: 0.75rem;
    color: var(--muted);
}

@keyframes fadeUp {
    from { opacity: 0; transform: translateY(20px); }
    to   { opacity: 1; transform: translateY(0); }
}
.animate { animation: fadeUp 0.7s cubic-bezier(0.16,1,0.3,1) both; }

        body { display: flex; flex-direction: column; align-items: center; justify-content: center; }
        .hero { position: relative; z-index: 1; text-align: center; padding: 60px 24px; animation: fadeUp 0.8s cubic-bezier(0.16,1,0.3,1) both; }
        .hero-eyebrow { font-size: 0.72rem; letter-spacing: 0.35em; text-transform: uppercase; color: var(--amber); margin-bottom: 20px; }
        .hero-title { font-family: 'Bebas Neue', sans-serif; font-size: clamp(5rem, 15vw, 10rem); line-height: 0.9; letter-spacing: 0.06em; background: linear-gradient(140deg, var(--text) 40%, var(--amber) 100%); -webkit-background-clip: text; -webkit-text-fill-color: transparent; background-clip: text; margin-bottom: 24px; }
        .hero-sub { font-size: 0.88rem; color: var(--muted); letter-spacing: 0.05em; margin-bottom: 48px; max-width: 300px; margin-left: auto; margin-right: auto; line-height: 1.7; }
        .hero-actions { display: flex; gap: 14px; justify-content: center; flex-wrap: wrap; }
        .disc-ring { position: fixed; border-radius: 50%; border: 1px solid var(--border); pointer-events: none; z-index: 0; }
        .disc-ring-1 { width: 600px; height: 600px; bottom: -200px; right: -200px; }
        .disc-ring-2 { width: 380px; height: 380px; bottom: -100px; right: -80px; opacity: 0.5; }
        .disc-ring-3 { width: 160px; height: 160px; bottom: 60px; right: 100px; opacity: 0.3; }
        .disc-ring-3::after { content: ''; position: absolute; inset: 35%; border-radius: 50%; background: var(--amber); opacity: 0.4; }
        .footer-note { position: fixed; bottom: 24px; font-size: 0.68rem; color: var(--muted); letter-spacing: 0.12em; z-index: 1; text-transform: uppercase; }
    </style>
</head>
<body>
    <div class="disc-ring disc-ring-1"></div>
    <div class="disc-ring disc-ring-2"></div>
    <div class="disc-ring disc-ring-3"></div>
    <div class="hero">
        <p class="hero-eyebrow">✦ The finest albums, delivered</p>
        <div class="hero-title">SEBO</div>
        <p class="hero-sub">Your go-to spot for physical albums — jazz, rock, soul &amp; everything in between.</p>
        <div class="hero-actions">
            <a href="auth" class="btn btn-primary">Sign In</a>
            <a href="register" class="btn btn-secondary">Create Account</a>
        </div>
    </div>
    <p class="footer-note">&copy; 2026 SEBO</p>
</body>
</html>
