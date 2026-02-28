<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SEBO — My Orders</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link href="https://fonts.googleapis.com/css2?family=Bebas+Neue&family=Outfit:wght@300;400;500;600&display=swap" rel="stylesheet">
    <style>
        :root {
            --bg: #111010; --surface: #1a1918; --surface2: #221f1e;
            --amber: #e8833a; --amber-light: #f0a060; --amber-dim: rgba(232,131,58,0.15);
            --text: #ede9e3; --muted: #7a7066;
            --border: rgba(232,131,58,0.18); --border-soft: rgba(255,255,255,0.06);
        }
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }
        body { background: var(--bg); color: var(--text); font-family: 'Outfit', sans-serif; font-weight: 300; min-height: 100vh; }

        .navbar { display: flex; align-items: center; justify-content: space-between; padding: 18px 40px; border-bottom: 1px solid var(--border); background: var(--surface); }
        .navbar-brand { font-family: 'Bebas Neue', sans-serif; font-size: 1.8rem; letter-spacing: 0.12em; color: var(--amber); text-decoration: none; }
        .navbar-links { display: flex; gap: 24px; }
        .navbar-links a { font-size: 0.78rem; letter-spacing: 0.1em; text-transform: uppercase; color: var(--muted); text-decoration: none; transition: color 0.2s; }
        .navbar-links a:hover, .navbar-links a.active { color: var(--amber); }

        .page-wrap { max-width: 1100px; margin: 0 auto; padding: 40px 24px; }
        .page-header { margin-bottom: 28px; padding-bottom: 20px; border-bottom: 1px solid var(--border-soft); }
        .page-header .greeting { font-size: 0.75rem; letter-spacing: 0.15em; text-transform: uppercase; color: var(--amber); margin-bottom: 6px; }
        h1 { font-family: 'Bebas Neue', sans-serif; font-size: 2.6rem; letter-spacing: 0.05em; }

        /* Order group card */
        .order-card {
            background: var(--surface);
            border: 1px solid var(--border);
            margin-bottom: 24px;
            position: relative;
        }
        .order-card::before {
            content: '';
            position: absolute;
            top: 0; left: 8%; right: 8%; height: 1px;
            background: linear-gradient(90deg, transparent, var(--amber), transparent);
        }
        .order-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 18px 24px;
            border-bottom: 1px solid var(--border-soft);
        }
        .order-num {
            font-family: 'Bebas Neue', sans-serif;
            font-size: 1.2rem;
            letter-spacing: 0.1em;
            color: var(--amber);
        }
        .order-date {
            font-size: 0.78rem;
            color: var(--muted);
            letter-spacing: 0.05em;
        }
        .order-total-label {
            font-size: 0.68rem;
            text-transform: uppercase;
            letter-spacing: 0.1em;
            color: var(--muted);
        }
        .order-total-value {
            font-family: 'Bebas Neue', sans-serif;
            font-size: 1.4rem;
            color: var(--amber);
            letter-spacing: 0.05em;
        }

        /* Table inside card */
        table { width: 100%; border-collapse: collapse; }
        th {
            background: var(--surface2);
            font-family: 'Bebas Neue', sans-serif;
            font-size: 0.8rem;
            letter-spacing: 0.1em;
            color: var(--amber);
            padding: 10px 24px;
            text-align: left;
            border-bottom: 1px solid var(--border);
        }
        td {
            padding: 12px 24px;
            border-bottom: 1px solid var(--border-soft);
            font-size: 0.88rem;
            color: var(--text);
        }
        tr:last-child td { border-bottom: none; }
        tr:hover td { background: var(--surface2); }
        .price-cell { font-family: 'Bebas Neue', sans-serif; font-size: 1rem; color: var(--amber); }

        /* Empty state */
        .empty-state {
            text-align: center;
            padding: 60px 24px;
            color: var(--muted);
        }
        .empty-state .icon { font-size: 3rem; margin-bottom: 16px; }
        .empty-state p { margin-bottom: 20px; font-size: 0.9rem; }

        .btn { display: inline-block; padding: 12px 22px; font-family: 'Outfit', sans-serif; font-size: 0.78rem; font-weight: 500; letter-spacing: 0.1em; text-transform: uppercase; text-decoration: none; cursor: pointer; border: none; transition: all 0.25s; border-radius: 2px; }
        .btn-primary { background: var(--amber); color: #111; }
        .btn-primary:hover { background: var(--amber-light); transform: translateY(-2px); box-shadow: 0 6px 20px rgba(232,131,58,0.3); }

        @keyframes fadeUp { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }
        .animate { animation: fadeUp 0.7s cubic-bezier(0.16,1,0.3,1) both; }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="dashboard" class="navbar-brand">SEBO</a>
    <div class="navbar-links">
        <a href="catalogue">Catalogue</a>
        <a href="cart">Cart</a>
        <a href="commandes" class="active">Orders</a>
        <a href="home">Sign Out</a>
    </div>
</nav>

<div class="page-wrap animate">
    <div class="page-header">
        <p class="greeting">✦ ${sessionScope.user.name()}</p>
        <h1>My Orders</h1>
    </div>

    <c:choose>
    <c:when test="${empty commandes}">
        <div class="empty-state">
            <div class="icon">📦</div>
            <p>You haven't placed any orders yet.</p>
            <a href="catalogue" class="btn btn-primary">Browse Catalogue</a>
        </div>
    </c:when>
    <c:otherwise>
        <%-- Group lines by numCommande --%>
    <c:set var="currentNum" value="-1" />

    <c:forEach var="ligne" items="${commandes}">

        <%-- Open a new card when numCommande changes --%>
    <c:if test="${ligne.numCommande != currentNum}">

        <%-- Close previous card if not the first --%>
    <c:if test="${currentNum != -1}">
    </table>
</div>
</c:if>

<c:set var="currentNum" value="${ligne.numCommande}" />

    <%-- Compute order total for this commande --%>
<c:set var="orderTotal" value="0" />
<c:forEach var="l" items="${commandes}">
    <c:if test="${l.numCommande == ligne.numCommande}">
        <c:set var="orderTotal" value="${orderTotal + l.total}" />
    </c:if>
</c:forEach>

<div class="order-card">
    <div class="order-header">
        <div>
            <div class="order-num">Order #${ligne.numCommande}</div>
            <div class="order-date">${ligne.dateCommande}</div>
        </div>
        <div style="text-align:right;">
            <div class="order-total-label">Order Total</div>
            <div class="order-total-value">€ <fmt:formatNumber value="${orderTotal}" maxFractionDigits="2"/></div>
        </div>
    </div>
    <table>
        <thead>
        <tr>
            <th>Reference</th>
            <th>Title</th>
            <th>Artist</th>
            <th>Unit Price</th>
            <th>Qty</th>
            <th>Total</th>
        </tr>
        </thead>
        </c:if>

            <%-- Table row for this ligne --%>
        <tr>
            <td style="font-family:'Bebas Neue',sans-serif;color:var(--amber);letter-spacing:0.08em;">${ligne.reference}</td>
            <td>${ligne.title}</td>
            <td>${ligne.author}</td>
            <td class="price-cell">€ ${ligne.prix}</td>
            <td>${ligne.qteCde}</td>
            <td class="price-cell">€ ${ligne.total}</td>
        </tr>

        </c:forEach>

            <%-- Close last card --%>
        <c:if test="${currentNum != -1}">
    </table>
</div>
</c:if>

</c:otherwise>
</c:choose>
</div>

</body>
</html>