<%--
  Created by IntelliJ IDEA.
  User: amzazi
  Date: 2/24/26
  Time: 11:23 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    /* =============================================
       SEBO — Design System
       Style: Luxury Minimal / Editorial
       Thème: Sombre, doré, raffiné
       Fonts: Cormorant Garamond (titres) + DM Sans (corps)
       ============================================= */

    :root {
        --bg:        #0d0d0d;
        --surface:   #141414;
        --gold:      #c9a84c;
        --gold-light:#e8c97a;
        --text:      #f0ece4;
        --muted:     #7a7368;
        --border:    rgba(201,168,76,0.2);
    }

    *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }

    body {
        background-color: var(--bg);
        color: var(--text);
        font-family: 'DM Sans', sans-serif;
        font-weight: 300;
        min-height: 100vh;
        display: flex;
        align-items: center;
        justify-content: center;
        overflow: hidden;
    }

    /* ---- Noise texture overlay ---- */
    body::before {
        content: '';
        position: fixed;
        inset: 0;
        background-image: url("data:image/svg+xml,%3Csvg viewBox='0 0 200 200' xmlns='http://www.w3.org/2000/svg'%3E%3Cfilter id='noise'%3E%3CfeTurbulence type='fractalNoise' baseFrequency='0.9' numOctaves='4' stitchTiles='stitch'/%3E%3C/filter%3E%3Crect width='100%25' height='100%25' filter='url(%23noise)' opacity='0.04'/%3E%3C/svg%3E");
        pointer-events: none;
        z-index: 0;
        opacity: 0.5;
    }

    /* ---- Radial glow background ---- */
    body::after {
        content: '';
        position: fixed;
        top: -20%;
        left: 50%;
        transform: translateX(-50%);
        width: 700px;
        height: 700px;
        background: radial-gradient(circle, rgba(201,168,76,0.07) 0%, transparent 70%);
        pointer-events: none;
        z-index: 0;
    }

    /* ---- Card ---- */
    .card {
        position: relative;
        z-index: 1;
        background: var(--surface);
        border: 1px solid var(--border);
        padding: 60px 70px;
        max-width: 520px;
        width: 90%;
        text-align: center;
        animation: fadeUp 0.9s cubic-bezier(0.16, 1, 0.3, 1) both;
    }

    /* subtle top accent line */
    .card::before {
        content: '';
        position: absolute;
        top: 0; left: 10%; right: 10%;
        height: 1px;
        background: linear-gradient(90deg, transparent, var(--gold), transparent);
    }

    /* ---- Logo / Brand ---- */
    .brand {
        font-family: 'Cormorant Garamond', serif;
        font-size: 13px;
        font-weight: 400;
        letter-spacing: 0.35em;
        text-transform: uppercase;
        color: var(--gold);
        margin-bottom: 36px;
    }

    /* ---- Divider ---- */
    .divider {
        width: 40px;
        height: 1px;
        background: var(--gold);
        margin: 0 auto 36px;
        opacity: 0.5;
    }

    /* ---- Heading ---- */
    h1 {
        font-family: 'Cormorant Garamond', serif;
        font-size: 2.4rem;
        font-weight: 300;
        line-height: 1.3;
        letter-spacing: 0.01em;
        color: var(--text);
        margin-bottom: 14px;
    }

    .subtitle {
        font-size: 0.85rem;
        color: var(--muted);
        letter-spacing: 0.04em;
        margin-bottom: 48px;
    }

    /* ---- Buttons ---- */
    .actions {
        display: flex;
        flex-direction: column;
        gap: 14px;
    }

    .btn {
        display: block;
        padding: 14px 24px;
        font-family: 'DM Sans', sans-serif;
        font-size: 0.8rem;
        font-weight: 400;
        letter-spacing: 0.12em;
        text-transform: uppercase;
        text-decoration: none;
        transition: all 0.3s ease;
        cursor: pointer;
    }

    /* Primary: gold fill */
    .btn-primary {
        background: var(--gold);
        color: #0d0d0d;
        border: 1px solid var(--gold);
    }
    .btn-primary:hover {
        background: var(--gold-light);
        border-color: var(--gold-light);
        transform: translateY(-2px);
        box-shadow: 0 8px 24px rgba(201,168,76,0.25);
    }

    /* Secondary: ghost */
    .btn-secondary {
        background: transparent;
        color: var(--text);
        border: 1px solid rgba(240,236,228,0.2);
    }
    .btn-secondary:hover {
        border-color: var(--gold);
        color: var(--gold);
        transform: translateY(-2px);
    }

    /* ---- Footer note ---- */
    .card-footer {
        margin-top: 40px;
        font-size: 0.72rem;
        color: var(--muted);
        letter-spacing: 0.06em;
    }

    /* ---- Animation ---- */
    @keyframes fadeUp {
        from { opacity: 0; transform: translateY(28px); }
        to   { opacity: 1; transform: translateY(0); }
    }
</style>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<div class="card">
    <p class="brand">SEBO</p>
    <div class="divider"></div>
    <h1>welcome</h1>
    <p class="subtitle">do you want to login / register</p>
    <div class="actions">
        <a href="auth"  class="btn btn-primary" >already a client</a>
        <a href="register" class="btn btn-secondary">new client : register</a>
        <p class="card-footer">&copy; 2026 SEBO — Copyright</p>
    </div>
</div>
</body>
</html>

