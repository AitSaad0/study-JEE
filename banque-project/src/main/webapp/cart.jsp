<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SEBO — Cart</title>
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
        .navbar-links a:hover { color: var(--amber); }
        .page-wrap { max-width: 800px; margin: 0 auto; padding: 40px 24px; }
        .page-header { margin-bottom: 28px; padding-bottom: 20px; border-bottom: 1px solid var(--border-soft); }
        .page-header .greeting { font-size: 0.75rem; letter-spacing: 0.15em; text-transform: uppercase; color: var(--amber); margin-bottom: 6px; }
        h1 { font-family: 'Bebas Neue', sans-serif; font-size: 2.6rem; }

        .cart-card {
            background: var(--surface);
            border: 1px solid var(--border);
            padding: 36px;
            position: relative;
        }
        .cart-card::before {
            content: '';
            position: absolute;
            top: 0; left: 8%; right: 8%; height: 1px;
            background: linear-gradient(90deg, transparent, var(--amber), transparent);
        }
        .cart-row {
            display: flex;
            justify-content: space-between;
            align-items: center;
            padding: 14px 0;
            border-bottom: 1px solid var(--border-soft);
        }
        .cart-row:last-of-type { border-bottom: none; }
        .field-label { font-size: 0.68rem; letter-spacing: 0.15em; text-transform: uppercase; color: var(--muted); margin-bottom: 4px; }
        .field-value { font-size: 1rem; color: var(--text); }
        .price-large { font-family: 'Bebas Neue', sans-serif; font-size: 2rem; color: var(--amber); letter-spacing: 0.05em; }

        .qty-input {
            width: 70px;
            padding: 8px 12px;
            background: var(--surface2);
            border: 1px solid var(--border-soft);
            color: var(--text);
            font-family: 'Outfit', sans-serif;
            font-size: 1rem;
            text-align: center;
            outline: none;
            border-radius: 2px;
        }
        .qty-input:focus { border-color: var(--amber); box-shadow: 0 0 0 3px var(--amber-dim); }

        .btn { display: inline-block; padding: 12px 22px; font-family: 'Outfit', sans-serif; font-size: 0.78rem; font-weight: 500; letter-spacing: 0.1em; text-transform: uppercase; text-decoration: none; cursor: pointer; border: none; transition: all 0.25s; border-radius: 2px; }
        .btn-primary { background: var(--amber); color: #111; }
        .btn-primary:hover { background: var(--amber-light); transform: translateY(-2px); box-shadow: 0 6px 20px rgba(232,131,58,0.3); }
        .btn-secondary { background: transparent; color: var(--text); border: 1px solid var(--border-soft); }
        .btn-secondary:hover { border-color: var(--amber); color: var(--amber); transform: translateY(-2px); }
        .actions { display: flex; gap: 12px; margin-top: 28px; }

        .error-msg { background: rgba(192,57,43,0.15); border: 1px solid rgba(192,57,43,0.4); color: #e74c3c; padding: 10px 14px; font-size: 0.82rem; margin-bottom: 20px; border-radius: 2px; }
        .stock-badge { font-size: 0.75rem; color: var(--muted); margin-top: 4px; }
        .stock-low { color: #e8833a; }
        .stock-out { color: #e74c3c; }

        @keyframes fadeUp { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }
        .animate { animation: fadeUp 0.7s cubic-bezier(0.16,1,0.3,1) both; }
    </style>
</head>
<body>

<nav class="navbar">
    <a href="dashboard" class="navbar-brand">SEBO</a>
    <div class="navbar-links">
        <a href="catalogue">Catalogue</a>
        <a href="cart" style="color: var(--amber);">Cart</a>
        <a href="commandes">Orders</a>
        <a href="home">Sign Out</a>
    </div>
</nav>

<div class="page-wrap animate">
    <div class="page-header">
        <p class="greeting">✦ Review your order</p>
        <h1>Cart</h1>
    </div>

    <c:if test="${not empty error}">
        <div class="error-msg">${error}</div>
    </c:if>

    <c:choose>
        <c:when test="${not empty article}">
            <div class="cart-card">

                <div class="cart-row">
                    <div>
                        <div class="field-label">Title</div>
                        <div class="field-value" style="font-family:'Bebas Neue',sans-serif;font-size:1.6rem;letter-spacing:0.05em;">${article.title}</div>
                    </div>
                </div>

                <div class="cart-row">
                    <div>
                        <div class="field-label">Artist</div>
                        <div class="field-value">${article.author}</div>
                    </div>
                    <div>
                        <div class="field-label">Reference</div>
                        <div class="field-value" style="font-family:'Bebas Neue',sans-serif;color:var(--amber);">${article.reference}</div>
                    </div>
                </div>

                <div class="cart-row">
                    <div>
                        <div class="field-label">Unit Price</div>
                        <div class="price-large">€ ${article.prix}</div>
                    </div>
                    <div>
                        <div class="field-label">In Stock</div>
                        <div class="field-value
                            <c:choose>
                                <c:when test="${article.stock == 0}"> stock-out</c:when>
                                <c:when test="${article.stock <= 3}"> stock-low</c:when>
                            </c:choose>">
                                ${article.stock} copies
                        </div>
                    </div>
                </div>

                    <%-- Buy form — POST to BuyServlet --%>
                <form action="buy" method="post">
                    <input type="hidden" name="codeArticle" value="${article.codeArticle}" />

                    <div class="cart-row">
                        <div>
                            <div class="field-label">Quantity</div>
                            <input type="number" name="qteCde" value="1"
                                   min="1" max="${article.stock}"
                                   class="qty-input" />
                        </div>
                    </div>

                    <div class="actions">
                        <a href="catalogue" class="btn btn-secondary">← Back</a>
                        <c:choose>
                            <c:when test="${article.stock > 0}">
                                <button type="submit" class="btn btn-primary">✓ Confirm Order</button>
                            </c:when>
                            <c:otherwise>
                                <button type="submit" class="btn btn-primary" disabled
                                        style="opacity:0.4;cursor:not-allowed;">Out of Stock</button>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </form>

            </div>
        </c:when>
        <c:otherwise>
            <p style="color:var(--muted);">No article selected. <a href="catalogue" style="color:var(--amber);">Back to catalogue</a></p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>