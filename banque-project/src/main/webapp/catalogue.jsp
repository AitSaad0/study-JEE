<%@ page import="java.util.List" %>
<%@ page import="com.example.banqueproject.entity.Categories" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.banqueproject.dto.ArticlesDto" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>SEBO — Catalogue</title>
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
        .album-cover { width: 44px; height: 44px; object-fit: cover; border: 1px solid var(--border-soft); }
        .ref-link { font-family: 'Bebas Neue', sans-serif; font-size: 0.85rem; letter-spacing: 0.08em; color: var(--amber); text-decoration: none; }
        .ref-link:hover { text-decoration: underline; }
        .price-cell { font-family: 'Bebas Neue', sans-serif; font-size: 1rem; letter-spacing: 0.05em; color: var(--amber); }
    </style>
</head>
<body>
    <nav class="navbar">
        <a href="dashboard" class="navbar-brand">SEBO</a>
        <div class="navbar-links">
            <a href="catalogue" style="color: var(--amber);">Catalogue</a>
            <a href="/panier">Cart</a>
            <a href="/commandes">Orders</a>
            <a href="home">Sign Out</a>
        </div>
    </nav>
    <div class="page-wrap animate">
        <div class="page-header">
            <p class="greeting">✦ Hi, ${sessionScope.client.nom()}</p>
            <h1>Catalogue</h1>
        </div>
        <%
            List<Categories> listeCategories = (ArrayList<Categories>) request.getSession().getAttribute("categories");
            List<ArticlesDto> articles = (List<ArticlesDto>) session.getAttribute("articles");
        %>
        <div class="filter-bar">
            <label for="genre" style="margin-top:0;">Category</label>
            <form action="catalogue" method="get" style="display:flex; gap:12px; align-items:center; flex:1; flex-wrap:wrap;">
                <select id="genre" name="category">
                    <option value="">— All categories —</option>
                    <option value="all">All</option>
                    <% for (Categories c : listeCategories) { %>
                    <option value="<%= c.getIdCat() %>"><%= c.getCat() %></option>
                    <% } %>
                </select>
                <button type="submit" class="btn btn-primary btn-sm">Filter</button>
            </form>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Ref</th><th>Title</th><th>Artist</th><th>Cover</th><th>Price</th><th></th>
                </tr>
            </thead>
            <tbody>
                <% for (ArticlesDto article : articles) { %>
                <tr>
                    <td><a href="detail?reference=<%=article.getReference()%>" class="ref-link"><%= article.getReference() %></a></td>
                    <td><%= article.getTitle() %></td>
                    <td><%= article.getAuthor() %></td>
                    <td>
                        <% if (article.getPhoto() != null && !article.getPhoto().isEmpty()) { %>
                            <img src="<%= article.getPhoto() %>" alt="cover" class="album-cover">
                        <% } else { %>
                            <div class="album-cover" style="background:var(--surface2);display:flex;align-items:center;justify-content:center;font-size:1.2rem;">🎵</div>
                        <% } %>
                    </td>
                    <td class="price-cell"><%= article.getPrix() %> €</td>
                    <td><a href="cart?id=<%= article.getReference() %>" class="btn btn-primary btn-sm">Add to Cart</a></td>
                </tr>
                <% } %>
            </tbody>
        </table>
    </div>
</body>
</html>
