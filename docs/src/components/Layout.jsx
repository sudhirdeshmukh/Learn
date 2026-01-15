import { Link } from 'react-router-dom';

export default function Layout({ children }) {
  const patterns = ['singleton', 'factory', 'builder', 'prototype', 'strategy', 'observer', 'decorator'];

  return (
    <div className="min-h-screen bg-gray-50">
      <nav className="bg-white shadow">
        <div className="max-w-7xl mx-auto px-4 py-4 flex justify-between">
          <Link to="/" className="text-xl font-bold text-blue-600">Design Patterns</Link>
          <div className="flex space-x-6">
            <Link to="/system-design" className="text-gray-700 hover:text-blue-600">System Design</Link>
            <Link to="/interview-qa" className="text-gray-700 hover:text-blue-600">Interview Q&A</Link>
            <Link to="/quick-revision" className="text-gray-700 hover:text-blue-600">Quick Revision</Link>
          </div>
        </div>
      </nav>
      <div className="flex">
        <aside className="w-64 bg-white shadow p-6">
          <h2 className="font-semibold mb-4">Patterns</h2>
          {patterns.map(p => (
            <Link key={p} to={`/pattern/${p}`} className="block py-2 text-sm text-gray-700 hover:text-blue-600 capitalize">{p}</Link>
          ))}
        </aside>
        <main className="flex-1 p-8">{children}</main>
      </div>
    </div>
  );
}
