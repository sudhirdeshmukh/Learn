import { Link } from 'react-router-dom';

export default function Home() {
  const patterns = [
    { name: 'Singleton', desc: 'Single instance with global access', icon: '🔒' },
    { name: 'Factory', desc: 'Create objects without specifying exact class', icon: '🏭' },
    { name: 'Builder', desc: 'Construct complex objects step by step', icon: '🏗️' },
    { name: 'Prototype', desc: 'Clone existing objects', icon: '📋' },
    { name: 'Strategy', desc: 'Interchangeable algorithms', icon: '🎯' },
    { name: 'Observer', desc: 'One-to-many notifications', icon: '👁️' },
    { name: 'Decorator', desc: 'Add functionality dynamically', icon: '🎨' },
  ];

  return (
    <div className="space-y-8">
      <div className="bg-gradient-to-r from-blue-600 to-indigo-700 rounded-lg shadow-xl p-8 text-white">
        <h1 className="text-4xl font-bold mb-4">Design Patterns Learning</h1>
        <p className="text-xl mb-6">Master design patterns with Spring Boot implementations and REST APIs</p>
        <Link to="/pattern/singleton" className="bg-white text-blue-600 px-6 py-3 rounded-md font-semibold inline-block">Start Learning</Link>
      </div>
      <div className="grid grid-cols-2 gap-6">
        {patterns.map(p => (
          <Link key={p.name} to={`/pattern/${p.name.toLowerCase()}`} className="bg-white rounded-lg shadow-md p-6 hover:shadow-xl">
            <div className="flex items-start space-x-4">
              <div className="text-4xl">{p.icon}</div>
              <div>
                <h3 className="text-xl font-semibold text-gray-900">{p.name}</h3>
                <p className="text-gray-600 text-sm">{p.desc}</p>
              </div>
            </div>
          </Link>
        ))}
      </div>
    </div>
  );
}
